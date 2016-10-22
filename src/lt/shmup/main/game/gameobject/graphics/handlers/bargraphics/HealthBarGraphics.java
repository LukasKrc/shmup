package lt.shmup.main.game.gameobject.graphics.handlers.bargraphics;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.graphics.handlers.BarGraphics;
import lt.shmup.main.game.gameobject.tracker.ValueTracker;

import java.awt.*;

public class HealthBarGraphics extends BarGraphics {

    private ValueTracker<Integer> healthValueTracker;

    public HealthBarGraphics(
        int width,
        int height,
        Color fillColor,
        Color borderColor,
        ValueTracker<Integer> healthValueTracker
    ) {
        super(width, height, fillColor, borderColor);
        this.healthValueTracker = healthValueTracker;
    }

    @Override
    public void render(Graphics2D graphics, GameObject gameObject) {
        graphics.setColor(Color.gray);
        graphics.fillRect(
                gameObject.getX(),
                gameObject.getY(),
                this.getWidth(),
                this.getHeight()
        );
        graphics.setColor(this.getFillColor());
        float healthPercent = this.healthValueTracker.getValue() / this.healthValueTracker.getMaximumValue();
        int barWidth = (int) (this.getWidth() * healthPercent);
        graphics.fillRect(
                gameObject.getX(),
                gameObject.getY(),
                barWidth,
                this.getHeight()
        );
        graphics.setColor(this.getBorderColor());
        graphics.drawRect(
                gameObject.getX(),
                gameObject.getY(),
                this.getWidth(),
                this.getHeight()
        );
    }
}
