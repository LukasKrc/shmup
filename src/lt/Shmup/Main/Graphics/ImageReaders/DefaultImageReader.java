package lt.Shmup.Main.Graphics.ImageReaders;

import lt.Shmup.Logger;
import lt.Shmup.Main.Graphics.ImageReader;
import lt.Shmup.Game;
import lt.Shmup.Main.Graphics.TextCenterer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class DefaultImageReader implements ImageReader {
    @Override
    public Image readImage(String imagePath, int width, int height) {
        try {
            Image image = this.readImageFromPath(imagePath);
            return image.getScaledInstance(width, height, Image.SCALE_FAST);
        } catch (IOException e) {
            Logger.getInstance().logException(e);
        }
        return null;
    }

    private Image readImageFromPath(String imagePath) throws IOException {
        return ImageIO.read(this.getInputStream(imagePath));
    }

    private InputStream getInputStream(String imagePath) {
        return Game.class.getResourceAsStream(imagePath);
    }
}
