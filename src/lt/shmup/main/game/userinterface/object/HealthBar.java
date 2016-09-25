package lt.shmup.main.game.userinterface.object;

import lt.shmup.main.Utility;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.userinterface.InterfaceObject;

import java.awt.*;

public class HealthBar implements InterfaceObject {

    private GameObject gameObject;
    private int positionX, positionY, width, height;
    private Color fillColor, borderColor;

    public HealthBar(
        GameObject gameObject,
        int x,
        int y,
        int width,
        int height,
        Color fillColor,
        Color borderColor
    ) {
        this.gameObject = gameObject;
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        GameObject gameObject = this.gameObject;
        graphics.setColor(Color.gray);
        graphics.fillRect(
            this.positionX,
            this.positionY,
            this.width,
            this.height
        );
        graphics.setColor(this.fillColor);
        float healthPercent = (float) gameObject.getHealth()
            / (float) gameObject.getMaxHealth();
        int barWidth = (int) (this.width * healthPercent);
        graphics.fillRect(
            this.positionX,
            this.positionY,
            barWidth,
            this.height
        );
        graphics.setColor(this.borderColor);
        graphics.drawRect(
                this.positionX,
                this.positionY,
                this.width,
                this.height
        );
    }
}
