package lt.shmup.main.game.gameobject.graphics;

import lt.shmup.main.game.gameobject.GameObject;

import java.awt.*;

public class GraphicsHandler {

    private int width, height;
    private Color color;

    public GraphicsHandler(
            int width,
            int height,
            Color color
    ) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void update(Graphics graphics, GameObject gameObject) {
        graphics.setColor(this.color);
        graphics.fillRect(
            gameObject.getX(),
            gameObject.getY(),
            this.width,
            this.height
        );
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
