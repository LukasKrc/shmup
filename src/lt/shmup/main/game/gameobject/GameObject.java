package lt.shmup.main.game.gameobject;

import lt.shmup.main.game.gameobject.collision.CollisionHandler;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.health.HealthHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    /**
     * Game object coordinates health and maximum health.
     */
    private int x, y;

    /**
     * Game object type identifier.
     */
    private Identifier identifier;

    /**
     * Game object movement velocities.
     */
    private int velocityX, velocityY;

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

    /**
     * Game object health handler.
     */
    private HealthHandler healthHandler;

    public GameObject(
            int x,
            int y,
            int health,
            int maxHealth,
            Identifier identifier,
            GraphicsHandler graphicsHandler,
            MovementHandler movementHandler,
            CollisionHandler collisionHandler,
            HealthHandler healthHandler
    ) {
        this.x = x;
        this.y = y;
        this.identifier = identifier;
        this.graphicsHandler = graphicsHandler;
        this.movementHandler = movementHandler;
        this.collisionHandler = collisionHandler;
        this.healthHandler = healthHandler;
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

    public HealthHandler getHealthHandler() {
        return healthHandler;
    }

    public void setHealthHandler(HealthHandler healthHandler) {
        this.healthHandler = healthHandler;
    }

    public void update() {
        if (this.movementHandler != null) {
            this.movementHandler.update(this);
        }
        if (this.collisionHandler != null) {
            this.collisionHandler.update(this);
        }
        if (this.healthHandler != null) {
            this.healthHandler.update(this);
        }
    }

    public void render(Graphics2D graphics) {
        if (this.graphicsHandler != null) {
            this.graphicsHandler.render(graphics, this);
        }
    }

    public abstract Rectangle getBounds();
}
