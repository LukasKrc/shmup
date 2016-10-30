package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class RotatingImageGraphics extends ImageGraphics {
    private float maxRadians = (float) (2 * Math.PI);
    private float rotationStep;
    private float rotation = 0;

    public RotatingImageGraphics(
        ImageWrapper imageWrapper,
        float rotationStep
    ) {
        super(imageWrapper);
        this.rotationStep = rotationStep;
    }

    @Override
    public EntityAwareRenderable clone() {
        return new RotatingImageGraphics(getImageWrapper(), rotationStep);
    }

    @Override
    protected void drawImage(
        Graphics2D graphics,
        Image image,
        Position position
    ) {
        rotation = (rotation % this.maxRadians) + this.rotationStep;
        AffineTransform transformer = getTransformation(position);
        graphics.drawImage(image, transformer, null);
    }

    private AffineTransform getTransformation(Position position) {
        ImageWrapper imageWrapper = getImageWrapper();
        AffineTransform transformation = AffineTransform.getRotateInstance(
            rotation,
            position.getX()  + (imageWrapper.getWidth() / 2),
            position.getY() + (imageWrapper.getHeight() / 2)
        );
        transformation.translate(position.getX(), position.getY());
        return transformation;
    }
}
