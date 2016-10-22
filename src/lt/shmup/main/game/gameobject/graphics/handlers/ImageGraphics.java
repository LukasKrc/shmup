package lt.shmup.main.game.gameobject.graphics.handlers;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageGraphics implements GraphicsHandler {

    private Image image;

    private float rotation;
    private int width, height;

    public ImageGraphics(String imagePath, int width, int height) {
        this.width = width;
        this.height = height;
        try {
            this.image = ImageIO
                .read(ImageGraphics.class.getClassLoader().getResourceAsStream(imagePath))
                .getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageGraphics(String imagePath, int width, int height, float initialRotation) {
        this(imagePath, width, height);
        this.rotation = initialRotation;
    }

    @Override
    public void render(Graphics2D graphics, GameObject gameObject) {
        int gameObjectX = gameObject.getX();
        int gameObjectY = gameObject.getY();
        if (this.rotation != 0) {
            AffineTransform transformation = AffineTransform.getRotateInstance(
                this.rotation, gameObjectX + (this.width / 2), gameObjectY + (this.height / 2)
            );
            transformation.translate(gameObjectX, gameObjectY);
            graphics.drawImage(this.image, transformation, null);
        } else {
            graphics.drawImage(this.image, gameObjectX, gameObjectY, null);
        }
    }
}
