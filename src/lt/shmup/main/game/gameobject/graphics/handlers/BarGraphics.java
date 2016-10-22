package lt.shmup.main.game.gameobject.graphics.handlers;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;

import java.awt.*;

public abstract class BarGraphics implements GraphicsHandler {

    private int width, height;

    private Color fillColor;

    private Color borderColor;

    public BarGraphics(
        int width,
        int height,
        Color fillColor,
        Color borderColor
    ) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public abstract void render(Graphics2D graphics, GameObject gameObject);
}
