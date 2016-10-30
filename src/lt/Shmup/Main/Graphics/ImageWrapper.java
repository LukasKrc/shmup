package lt.Shmup.Main.Graphics;

import java.awt.*;

public abstract class ImageWrapper {
    private int width, height;
    private Image image;

    public ImageWrapper(Image image, int width, int height) {
        this.width = width;
        this.height = height;
        this.image = image;
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

    public Image getImage() {
        return image;
    };

    public void setImage(Image image) {
        this.image = image;
    };

    public abstract ImageWrapper clone();
}
