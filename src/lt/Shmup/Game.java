package lt.Shmup;

import lt.Shmup.Main.GameState;
import lt.Shmup.Main.Initializer;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.Input.KeyboardInputHandler;
import lt.Shmup.Main.Input.MouseInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.HashMap;


public class Game implements Runnable {

    /**
     * Main Main thread.
     */
    private Thread thread;

    /**
     * Game frame.
     */
    private JFrame frame;

    /**
     * Game canvas.
     */
    private Canvas canvas;

    /**
     * Object Healths instance that updates and renders Main objects.
     */
    private HashMap<GameState, ObjectHandler> objectHandlers = new HashMap<>();

    /**
     * Current Main gameState.
     */
    private GameState gameState;

    /**
     * Log Healths.
     */
    private Logger logger;

    public Game() {
        canvas = new Canvas();
        frame = this.createGameFrame();
        frame.add(canvas);
        startGame();
    }

    private JFrame createGameFrame() {
        JFrame gameFrame = new JFrame(Config.str("game/title"));

        gameFrame.setPreferredSize(new Dimension(
                Config.intg("window/width"),
                Config.intg("window/width"))
        );
        gameFrame.setMaximumSize(new Dimension(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT));
        gameFrame.setMinimumSize(new Dimension(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        return gameFrame;
    }

    private void startGame() {
        setGameState(GameState.Menu);
        initialize();
        logger = Logger.getInstance();
        logger.log("Game started");
        start();
    }

    private void initialize() {
        Initializer initializer = new Initializer(this);
        initializer.initialize();
        createObjectHandlers();
        initializer.setObjectHandlers(objectHandlers);
        addListenersToCanvas();
        initializer.createObjects();
    }

    private void addListenersToCanvas() {
        KeyboardInputHandler keyboardInputHandler =
                (KeyboardInputHandler) Container.get(KeyboardInputHandler.class);
        MouseInputHandler mouseInputHandler =
                (MouseInputHandler) Container.get(MouseInputHandler.class);
        canvas.addKeyListener(keyboardInputHandler);
        canvas.addMouseListener(mouseInputHandler);
        canvas.addMouseMotionListener(mouseInputHandler);
    }

    private void createObjectHandlers() {
        for (GameState state : GameState.values()) {
            objectHandlers.put(
                    state,
                    (ObjectHandler) Container.get(ObjectHandler.class, true, true)
            );
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.canvas.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (!isGameStopped()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (!isGameStopped()) {
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

    private boolean isGameStopped() {
        return getGameState() == GameState.Stopped;
    }

    private void update() {
        try {
            objectHandlers.get(this.gameState).update();
        } catch (Exception e) {
            logger.logException(e);
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = this.canvas.getBufferStrategy();
        if (bufferStrategy == null) {
            this.canvas.createBufferStrategy(3);
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
                objectHandlers.get(gameState).render(graphics);
                graphics.dispose();
            } catch (Exception e) {
                logger.logException(e);
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
