package lt.shmup.main;

import lt.shmup.main.game.GameState;
import lt.shmup.main.game.commands.dispatcher.HashMapDispatcher;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.factory.FactoryFactory;
import lt.shmup.main.game.gameobject.factory.GameObjectFactory;
import lt.shmup.main.game.gameobject.graphics.handlers.BarGraphics;
import lt.shmup.main.game.gameobject.graphics.handlers.bargraphics.HealthBarGraphics;
import lt.shmup.main.game.gameobject.health.HealthHandler;
import lt.shmup.main.game.gameobject.tracker.valuetracker.HealthValueTracker;
import lt.shmup.main.game.input.KeyInputHandler;
import lt.shmup.main.game.input.KeyStateHandler;
import lt.shmup.main.game.input.commands.FirePressed;
import lt.shmup.main.game.input.commands.firing.FireReleased;
import lt.shmup.main.game.input.commands.movement.pressed.MoveDown;
import lt.shmup.main.game.input.commands.movement.pressed.MoveLeft;
import lt.shmup.main.game.input.commands.movement.pressed.MoveRight;
import lt.shmup.main.game.input.commands.movement.pressed.MoveUp;
import lt.shmup.main.game.input.commands.movement.released.Horizontal;
import lt.shmup.main.game.input.commands.movement.released.Vertical;
import lt.shmup.main.game.input.state.HashMapKeyStateHandler;
import lt.shmup.main.game.gameobject.object.userInterface.HealthBar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

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
    private ObjectHandler objectHandler;

    /**
     * Key input handling object.
     */
    private KeyInputHandler keyInputHandler;

    /**
     * Handles current keyboard button states (pressed, released)
     */
    private KeyStateHandler keyStateHandler;

    /**
     * Current game state.
     */
    private GameState state;

    /**
     * Log handler.
     */
    private Logger logger;

    public Game() {
        new Window(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT, "Shmup", this);
        this.startGame();
    }

    private void startGame() {
        this.objectHandler = new ObjectHandler();
        this.keyStateHandler = new HashMapKeyStateHandler();
        this.keyInputHandler = new KeyInputHandler(
                this.keyStateHandler,
                new HashMapDispatcher(),
                new HashMapDispatcher()
        );
        this.addKeyListener(this.keyInputHandler);

        this.createGameObjects();

        this.logger = Logger.getInstance();
        this.logger.log("Game started");
    }

    private void createGameObjects() {
        FactoryFactory factoryFactory = new FactoryFactory(this.objectHandler);
        GameObjectFactory playerFactory = factoryFactory.getFactory("player");
        GameObjectFactory enemyFactory = factoryFactory.getFactory("enemy");
        GameObject player = playerFactory.getCharacter(null);
        GameObject enemy = enemyFactory.getCharacter(null);

        HealthHandler playerHealthHandler = player.getHealthHandler();
        this.objectHandler.addObject(
            new HealthBar(
                15,
                15,
                200,
                30,
                new HealthBarGraphics(
                    200,
                    30,
                    Color.GREEN,
                    Color.WHITE,
                    new HealthValueTracker(playerHealthHandler, playerHealthHandler.getMinimumHealth(), playerHealthHandler.getMaximumHealth())
                )
            )
        );

        int playerVelocity = 5;
        MoveUp moveUpCommand = new MoveUp(player, playerVelocity);
        MoveDown moveDownCommand = new MoveDown(player, playerVelocity);
        MoveRight moveRightCommand = new MoveRight(player, playerVelocity);
        MoveLeft moveLeftCommand = new MoveLeft(player, playerVelocity);
        FirePressed firePressedCommand = new FirePressed(this.objectHandler, player);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_W, moveUpCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_S, moveDownCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_D, moveRightCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_A, moveLeftCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_SPACE, firePressedCommand);
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_W, new Vertical(player, this.keyStateHandler, KeyEvent.VK_S, moveDownCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_S, new Vertical(player, this.keyStateHandler, KeyEvent.VK_W, moveUpCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_D, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_A, moveLeftCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_A, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_D, moveRightCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_SPACE, new FireReleased(firePressedCommand));

        this.objectHandler.addObject(player);
        this.objectHandler.addObject(enemy);
    }

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
            this.objectHandler.update();
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
                this.objectHandler.render(graphics);
            } catch (Exception e) {
                this.logger.logException(e);
            } finally {
                graphics.dispose();
            }
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public static void main(String args[]) {
        System.setProperty("sun.java2d.opengl", "true");
        new Game();
    }
}
