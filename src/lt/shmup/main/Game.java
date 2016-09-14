package lt.shmup.main;

import lt.shmup.main.game.ObjectHandler;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    /**
     * Game window dimension constants;
     */
    private static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

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

    public Game() {
        new Window(WINDOW_WIDTH, WINDOW_HEIGHT, "Shmup", this);
        objectHandler = new ObjectHandler();
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
        objectHandler.update();
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
                objectHandler.render(graphics);
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
