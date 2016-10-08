package lt.shmup.main.game.gameobject;

import lt.shmup.main.game.gameobject.collision.CollisionHandler;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;
import lt.shmup.main.game.input.InputListener;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    /**
     * Game object coordinates health and maximum health.
     */
    private int x, y, maxHealth, health;

    /**
     * Game object type identifier.
     */
    private Identifier identifier;

    /**
     * Game object movement velocities.
     */
    private int velocityX, velocityY;

    /**
     * Input event listeners.
     */
    private LinkedList<InputListener> inputListeners = new LinkedList<>();

    /**
     * Game object graphics handler.
     */
    private GraphicsHandler graphicsHandler;

    /**
     * Game object movement handler.
     */
    private MovementHandler movementHandler;

    /**
     * Game object collision handler.
     */
    private CollisionHandler collisionHandler;

    public GameObject(
            int x,
            int y,
            int health,
            int maxHealth,
            Identifier identifier,
            GraphicsHandler graphicsHandler,
            MovementHandler movementHandler,
            CollisionHandler collisionHandler
    ) {
        this.x = x;
        this.y = y;
        this.maxHealth = maxHealth;
        this.identifier = identifier;
        this.graphicsHandler = graphicsHandler;
        this.movementHandler = movementHandler;
        this.health = health;
        this.collisionHandler = collisionHandler;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public LinkedList<InputListener> getInputListeners() {
        return this.inputListeners;
    }

    public void addInputListener(InputListener inputListener) {
        inputListener.setGameObject(this);
        this.inputListeners.add(inputListener);
    }

    public void removeInputListener(InputListener inputListener) {
        this.inputListeners.remove(inputListener);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void update() {
        if (this.movementHandler != null) {
            this.movementHandler.update(this);
        }
        if (this.collisionHandler != null) {
            this.collisionHandler.update(this);
        }
    }

    public void render(Graphics graphics) {
        if (this.graphicsHandler != null) {
            this.graphicsHandler.render(graphics, this);
        }
    };

    public abstract Rectangle getBounds();
}
