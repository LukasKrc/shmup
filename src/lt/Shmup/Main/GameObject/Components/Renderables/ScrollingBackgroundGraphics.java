package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Utility;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;

public class ScrollingBackgroundGraphics implements EntityAwareRenderable {
    private ImageWrapper imageWrapper;

    private Graphics graphics;
    private int initialXPosition;
    private int initialYPosition;
    private int finalXPosition;
    private int finalYPosition;
    private int width;
    private int height;

    public ScrollingBackgroundGraphics(
            ImageWrapper imageWrapper
    ) {
        this.imageWrapper = imageWrapper;
    }

    @Override
    public void render(Graphics2D graphics, Entity entity) {
        initializeFields(entity);
        this.graphics = graphics;
        drawHorizontalLines(entity.getPosition());
    }

    @Override
    public EntityAwareRenderable clone() {
        return new ScrollingBackgroundGraphics(imageWrapper);
    }

    private void drawHorizontalLines(Position position) {
        int xPosition = (int) (initialXPosition + position.getX());
        while (xPosition <= finalXPosition) {
            drawVerticalLines(xPosition, position);
            xPosition += width;
        }
    }

    private void drawVerticalLines(int xPosition, Position position) {
        int yPosition = (int) (initialYPosition + position.getY());
        while (yPosition < finalYPosition) {
            graphics.drawImage(
                    imageWrapper.getImage(),
                    xPosition,
                    yPosition,
                    null
            );
            yPosition += height;
        }
    }

    private void initializeFields(Entity entity) {
        Volume volume = entity.getVolume();
        this.width = (int) volume.getWidth();
        this.height = (int) volume.getHeight();
        this.initialXPosition = -width;
        this.initialYPosition = -height;
        this.finalXPosition = Utility.WINDOW_WIDTH + width;
        this.finalYPosition = Utility.WINDOW_HEIGHT + height;
    }
}
