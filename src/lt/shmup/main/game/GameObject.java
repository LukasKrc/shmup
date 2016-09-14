package lt.shmup.main.game;

import lt.shmup.main.game.gameobject.Identifier;

import java.awt.*;

public abstract class GameObject {

    /**
     * Game object coordinates.
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

    public GameObject(int x, int y, Identifier identifier) {
        this.x = x;
        this.y = y;
        this.identifier = identifier;
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

    public abstract void update();
    public abstract void render(Graphics g);
}
