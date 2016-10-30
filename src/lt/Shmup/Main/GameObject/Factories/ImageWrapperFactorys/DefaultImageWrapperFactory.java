package lt.Shmup.Main.GameObject.Factories.ImageWrapperFactorys;

import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactory;
import lt.Shmup.Main.Graphics.ImageReader;
import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Main.Graphics.ImageWrappers.Decorators.FlashingImageWrapperDecorator;
import lt.Shmup.Main.Graphics.ImageWrappers.DefaultImageWrapper;

import java.awt.*;

public class DefaultImageWrapperFactory implements ImageWrapperFactory {
    private ImageReader imageReader;

    public DefaultImageWrapperFactory(ImageReader imageReader) {
        this.imageReader = imageReader;
    }

    @Override
    public ImageWrapper getDefaultImageWrapper(
            String imagePath,
            int width,
            int height
    ) {
        Image image = imageReader.readImage(imagePath, width, height);
        return new DefaultImageWrapper(image, width, height);
    }

    @Override
    public FlashingImageWrapperDecorator getFlashingImageWrapper(
            ImageWrapper imageWrapper,
            float initialAlpha,
            float alphaStep,
            Color color
    ) {
        return new FlashingImageWrapperDecorator(
                imageWrapper,
                alphaStep,
                initialAlpha,
                color
        );
    }
}
