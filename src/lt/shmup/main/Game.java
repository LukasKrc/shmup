package lt.shmup.main;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
import lt.shmup.main.game.gameobject.graphics.handlers.GameEntity;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ClampDecorator;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.movement.handlers.PlayerMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ReflectDecorator;
import lt.shmup.main.game.gameobject.object.BasicEnemy;
import lt.shmup.main.game.gameobject.object.Player;
import lt.shmup.main.game.input.InputListener;
import lt.shmup.main.game.input.KeyInput;
import lt.shmup.main.game.input.events.pressed.MovementPressed;
import lt.shmup.main.game.input.events.released.MovementReleased;
import lt.shmup.main.game.userinterface.InterfaceHandler;
import lt.shmup.main.game.userinterface.object.HealthBar;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    /**
     * Main game thread.
     */
    private Thread thread;

    /**
     * Flag that defines whether game is runnning.
     */
    private boolean running = false;

    /**
     * Object handler instance that updates and renders game objects.
     */
    private ObjectHandler objectHandler;

    /**
     * Key input handling object.
     */
    private KeyInput keyInputHandler;

    private InterfaceHandler interfaceHandler;

    public Game() {
        this.objectHandler = new ObjectHandler();
        new Window(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT, "Shmup", this);

        this.interfaceHandler = new InterfaceHandler();

        this.createGameObjects();

        this.keyInputHandler = new KeyInput(this.objectHandler);
        this.addKeyListener(this.keyInputHandler);
        Logger logger = Logger.getInstance();
        logger.log("Game started");
    }

    private void createGameObjects() {
        GameObject player = new Player(
                Utility.WINDOW_WIDTH/2 - 32,
                Utility.WINDOW_HEIGHT/2 - 32,
                100,
                100,
                Identifier.Player,
                new GameEntity(32, 32, Color.white),
                new ClampDecorator(new PlayerMovement()),
                new HealthCollision(this.objectHandler)
        );

        this.interfaceHandler.addInterfaceObject(
            new HealthBar(player, 15, 15, 200, 30, Color.green, Color.white)
        );

        GameObject enemy = new BasicEnemy(
                Utility.WINDOW_WIDTH/2 - 32,
                Utility.WINDOW_HEIGHT/2 - 32,
                100,
                100,
                Identifier.Enemy,
                new GameEntity(16, 16, Color.red),
                new ReflectDecorator(new EnemyMovement()),
                null
        );

        InputListener inputListener = new InputListener();
        inputListener.addKeyPressedEvent(new MovementPressed(15, 5));
        inputListener.addKeyReleasedEvent(new MovementReleased());
        player.addInputListener(inputListener);

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
        this.objectHandler.update();
        this.interfaceHandler.update();
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
