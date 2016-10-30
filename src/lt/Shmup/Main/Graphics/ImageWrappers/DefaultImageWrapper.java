package lt.Shmup.Main.Graphics.ImageWrappers;

import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;

public class DefaultImageWrapper extends ImageWrapper {
    public DefaultImageWrapper(Image image, int width, int height) {
        super(image, width, height);
    }

    @Override
    public ImageWrapper clone() {
        return new DefaultImageWrapper(getImage(), getWidth(), getHeight());
    }
}
