package lt.shmup.main.game.gameobject;

import lt.shmup.main.game.input.InputListener;

import java.awt.*;
import java.util.LinkedList;

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

    /**
     * Input event listeners.
     */
    private LinkedList<InputListener> inputListeners = new LinkedList<>();

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

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
}
