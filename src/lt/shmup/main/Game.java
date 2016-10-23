package lt.shmup.main;

import lt.shmup.main.game.GameState;
import lt.shmup.main.game.commands.dispatcher.HashMapDispatcher;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.graphics.handlers.ButtonGraphicsHandler;
import lt.shmup.main.game.gameobject.object.userInterface.ButtonObject;
import lt.shmup.main.game.gameobject.object.userInterface.ButtonState;
import lt.shmup.main.game.input.KeyInputHandler;
import lt.shmup.main.game.input.KeyStateHandler;
import lt.shmup.main.game.input.MouseInputHandler;
import lt.shmup.main.game.input.commands.mouse.StartGameCommand;
import lt.shmup.main.game.input.state.HashMapKeyStateHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

public class Game extends Canvas implements Runnable {

    /**
     * Main game thread.
     */
    private Thread thread;

    /**
     * Flag that defines whether game is running.
     */
    private boolean running = false;

    /**
     * Object handler instance that updates and renders game objects.
     */
    private HashMap<GameState, ObjectHandler> objectHandlers = new HashMap<>();

    /**
     * Key input handling object.
     */
    private KeyInputHandler keyInputHandler;

    /**
     * Handles current keyboard button states (pressed, released)
     */
    private KeyStateHandler keyStateHandler;

    /**
     * Current game gameState.
     */
    private GameState gameState;

    /**
     * Log handler.
     */
    private Logger logger;

    public Game() {
        new Window(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT, "Shmup", this);
        this.startGame();
    }

    private void startGame() {
        this.setGameState(GameState.Menu);
        ObjectHandler gameObjectHandler = new ObjectHandler();
        ObjectHandler initialMenuObjecthandler = new ObjectHandler();
        this.createInitialMenuObjects(initialMenuObjecthandler);
        this.objectHandlers.put(GameState.Running, gameObjectHandler);
        this.objectHandlers.put(GameState.Menu, initialMenuObjecthandler);
        this.keyStateHandler = new HashMapKeyStateHandler();
        this.keyInputHandler = new KeyInputHandler(
                this.keyStateHandler,
                new HashMapDispatcher(),
                new HashMapDispatcher()
        );
        MouseInputHandler mouseInputHandler = new MouseInputHandler(new HashMapDispatcher());
        mouseInputHandler.addCommand(MouseInputHandler.CLICKED_EVENT, new StartGameCommand(this));
        this.addKeyListener(this.keyInputHandler);
        this.addMouseListener(mouseInputHandler);

//        this.createGameObjects(gameObjectHandler);

        this.logger = Logger.getInstance();
        this.logger.log("Game started");
    }

    private void createInitialMenuObjects(ObjectHandler initialMenuObjectHandler) {
        HashMap<ButtonState, Color> buttonStateFillColors = new HashMap<>();
        HashMap<ButtonState, Color> buttonStateBorderColors = new HashMap<>();
        buttonStateFillColors.put(ButtonState.Released, Color.GRAY);
        buttonStateFillColors.put(ButtonState.Depressed, Color.DARK_GRAY);
        buttonStateBorderColors.put(ButtonState.Released, Color.BLUE);
        buttonStateBorderColors.put(ButtonState.Depressed, Color.BLUE);
        initialMenuObjectHandler.addRenderableObject(new ButtonObject(
            new ButtonGraphicsHandler(),
            buttonStateFillColors,
            buttonStateBorderColors,
            50,
            50,
            100,
            50,
            "Play game"
        ));
    }

//    private void createGameObjects(ObjectHandler objectHandler) {
//        FactoryFactory factoryFactory = new FactoryFactory(objectHandler);
//        GameObjectFactory playerFactory = factoryFactory.getFactory("player");
//        GameObjectFactory enemyFactory = factoryFactory.getFactory("enemy");
//        GameObject player = playerFactory.getCharacter(null);
//        GameObject enemy = enemyFactory.getCharacter(null);
//
//        HealthHandler playerHealthHandler = player.getHealthHandler();
//        objectHandler.addObject(
//            new HealthBar(
//                15,
//                15,
//                200,
//                30,
//                new HealthBarGraphics(
//                    200,
//                    30,
//                    Color.GREEN,
//                    Color.WHITE,
//                    new HealthValueTracker(playerHealthHandler, playerHealthHandler.getMinimumHealth(), playerHealthHandler.getMaximumHealth())
//                )
//            )
//        );
//
//        int playerVelocity = 5;
//        MoveUp moveUpCommand = new MoveUp(player, playerVelocity);
//        MoveDown moveDownCommand = new MoveDown(player, playerVelocity);
//        MoveRight moveRightCommand = new MoveRight(player, playerVelocity);
//        MoveLeft moveLeftCommand = new MoveLeft(player, playerVelocity);
//        FirePressed firePressedCommand = new FirePressed(objectHandler, player);
//        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_W, moveUpCommand);
//        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_S, moveDownCommand);
//        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_D, moveRightCommand);
//        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_A, moveLeftCommand);
//        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_SPACE, firePressedCommand);
//        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_W, new Vertical(player, this.keyStateHandler, KeyEvent.VK_S, moveDownCommand));
//        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_S, new Vertical(player, this.keyStateHandler, KeyEvent.VK_W, moveUpCommand));
//        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_D, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_A, moveLeftCommand));
//        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_A, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_D, moveRightCommand));
//        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_SPACE, new FireReleased(firePressedCommand));
//
//        objectHandler.addObject(player);
//        objectHandler.addObject(enemy);
//    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void update() {
        try {
            this.objectHandlers.getOrDefault(this.gameState, new ObjectHandler()).update();
        } catch (Exception e) {
            this.logger.logException(e);
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        do {
            try {
                graphics.setColor(Color.black);
                graphics.fillRect(
                    0,
                    0,
                    Utility.WINDOW_WIDTH,
                    Utility.WINDOW_HEIGHT
                );
                this.objectHandlers.getOrDefault(this.gameState, new ObjectHandler()).render(graphics);
            } catch (Exception e) {
                this.logger.logException(e);
            } finally {
                graphics.dispose();
            }
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static void main(String args[]) {
        System.setProperty("sun.java2d.opengl", "true");
        new Game();
    }
}
