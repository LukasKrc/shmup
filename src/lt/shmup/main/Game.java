package lt.shmup.main;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.object.BasicEnemy;
import lt.shmup.main.game.gameobject.object.Player;
import lt.shmup.main.game.input.InputListener;
import lt.shmup.main.game.input.KeyInput;
import lt.shmup.main.game.input.events.pressed.MovementPressed;
import lt.shmup.main.game.input.events.released.MovementReleased;
import lt.shmup.main.game.userinterface.HeadsUpDisplay;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    /**
     * Game window dimension constants;
     */
    public static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

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

    private HeadsUpDisplay headsUpDisplay;

    public Game() {
        this.objectHandler = new ObjectHandler();
        new Window(WINDOW_WIDTH, WINDOW_HEIGHT, "Shmup", this);

        this.headsUpDisplay = new HeadsUpDisplay();

        GameObject player = new Player(
                WINDOW_WIDTH/2 - 32,
                WINDOW_HEIGHT/2 - 32,
                Identifier.Player,
                this.objectHandler
        );

        GameObject enemy = new BasicEnemy(
                WINDOW_WIDTH/2 - 32,
                WINDOW_HEIGHT/2 - 32,
                Identifier.Enemy
        );

        InputListener inputListener = new InputListener();
        inputListener.addKeyPressedEvent(new MovementPressed(15, 5));
        inputListener.addKeyReleasedEvent(new MovementReleased());
        player.addInputListener(inputListener);

        this.objectHandler.addObject(player);
        this.objectHandler.addObject(enemy);

        this.keyInputHandler = new KeyInput(this.objectHandler);
        this.addKeyListener(this.keyInputHandler);
        Logger logger = Logger.getInstance();
        logger.log("Game started");
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
        this.headsUpDisplay.update();
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
                graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                this.objectHandler.render(graphics);
                this.headsUpDisplay.render(graphics);
            } finally {
                graphics.dispose();
            }
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    public static int clamp(int value, int minimumValue, int maximumValue) {
        if (value >= maximumValue) {
            return maximumValue;
        } else if (value <= minimumValue) {
            return minimumValue;
        } else {
            return value;
        }
    }

    public static void main(String args[]) {
        System.setProperty("sun.java2d.opengl", "true");
        new Game();
    }
}
