package lt.shmup.main;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.behaviour.handlers.BasicEnemyBehaviour;
import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
import lt.shmup.main.game.gameobject.graphics.handlers.GameObjectGraphics;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ClampDecorator;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.movement.handlers.PlayerMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ReflectDecorator;
import lt.shmup.main.game.gameobject.object.BasicEnemy;
import lt.shmup.main.game.gameobject.object.Player;
import lt.shmup.main.game.input.KeyInputHandler;
import lt.shmup.main.game.input.KeyStateHandler;
import lt.shmup.main.game.input.commands.FireCommand;
import lt.shmup.main.game.input.commands.movement.pressed.MoveDown;
import lt.shmup.main.game.input.commands.movement.pressed.MoveLeft;
import lt.shmup.main.game.input.commands.movement.pressed.MoveRight;
import lt.shmup.main.game.input.commands.movement.pressed.MoveUp;
import lt.shmup.main.game.input.commands.movement.released.Horizontal;
import lt.shmup.main.game.input.commands.movement.released.Vertical;
import lt.shmup.main.game.input.state.HashMapKeyStateHandler;
import lt.shmup.main.game.userinterface.InterfaceHandler;
import lt.shmup.main.game.userinterface.object.HealthBar;

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
     * User interface object handler.
     */
    private InterfaceHandler interfaceHandler;

    /**
     * Handles current keyboard button states (pressed, released)
     */
    private KeyStateHandler keyStateHandler;

    /**
     * Log handler.
     */
    private Logger logger;

    public Game() {
        this.objectHandler = new ObjectHandler();
        new Window(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT, "Shmup", this);

        this.interfaceHandler = new InterfaceHandler();


        this.keyStateHandler = new HashMapKeyStateHandler();
        this.keyInputHandler = new KeyInputHandler(this.keyStateHandler);
        this.addKeyListener(this.keyInputHandler);

        this.createGameObjects();

        this.logger = Logger.getInstance();
        this.logger.log("Game started");
    }

    private void createGameObjects() {
        GameObject player = new Player(
            Utility.WINDOW_WIDTH/2 - 32,
            Utility.WINDOW_HEIGHT/2 - 32,
            100,
            100,
            Identifier.Player,
            new GameObjectGraphics(32, 32, Color.white),
            new ClampDecorator(new PlayerMovement()),
            new HealthCollision(this.objectHandler)
        );

        this.interfaceHandler.addInterfaceObject(
            new HealthBar(player, 15, 15, 200, 30, Color.green, Color.white)
        );

        GameObject enemy = new BasicEnemy(
            70,
            70,
            100,
            100,
            Identifier.Enemy,
            new GameObjectGraphics(16, 16, Color.red),
            new ReflectDecorator(new EnemyMovement()),
            new HealthCollision(this.objectHandler),
            new BasicEnemyBehaviour(this.objectHandler)
        );

        int playerVelocity = 5;
        MoveUp moveUpCommand = new MoveUp(player, playerVelocity);
        MoveDown moveDownCommand = new MoveDown(player, playerVelocity);
        MoveRight moveRightCommand = new MoveRight(player, playerVelocity);
        MoveLeft moveLeftCommand = new MoveLeft(player, playerVelocity);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_W, moveUpCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_S, moveDownCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_D, moveRightCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_A, moveLeftCommand);
        this.keyInputHandler.addKeyPressedCommand(KeyEvent.VK_SPACE, new FireCommand(this.objectHandler, player));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_W, new Vertical(player, this.keyStateHandler, KeyEvent.VK_S, moveDownCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_S, new Vertical(player, this.keyStateHandler, KeyEvent.VK_W, moveUpCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_D, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_A, moveLeftCommand));
        this.keyInputHandler.addKeyReleasedCommand(KeyEvent.VK_A, new Horizontal(player, this.keyStateHandler, KeyEvent.VK_D, moveRightCommand));

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
            this.interfaceHandler.update();
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
        Graphics graphics = bufferStrategy.getDrawGraphics();
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
                this.interfaceHandler.render(graphics);
            } catch (Exception e) {
                this.logger.logException(e);
            } finally {
                graphics.dispose();
            }
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    public static void main(String args[]) {
        System.setProperty("sun.java2d.opengl", "true");
        new Game();
    }
}
