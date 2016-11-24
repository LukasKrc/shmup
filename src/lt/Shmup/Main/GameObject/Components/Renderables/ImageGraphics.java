package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;

public class ImageGraphics implements Renderable {
    private ImageWrapper imageWrapper;
    public ImageGraphics(ImageWrapper imageWrapper) {
        this.imageWrapper = imageWrapper;
    }
    public ImageWrapper getImageWrapper() {
        return imageWrapper;
    }

    @Override
    public void render(Graphics2D graphics, Entity entity) {
        Image image = imageWrapper.getImage();
        drawImage(graphics, image, entity.getPosition());
    }

    @Override
    public Renderable clone() {
        return new ImageGraphics(imageWrapper.clone());
    }

    protected void drawImage(
        Graphics2D graphics,
        Image image,
        Position position
    ) {
        graphics.drawImage(
            image,
            (int) position.getX(),
            (int) position.getY(),
            null
        );
    }
}
