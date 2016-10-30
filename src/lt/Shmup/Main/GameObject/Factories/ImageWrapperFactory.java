package lt.Shmup.Main.GameObject.Factories;

import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Main.Graphics.ImageWrappers.Decorators.FlashingImageWrapperDecorator;

import java.awt.*;

public interface ImageWrapperFactory {
    ImageWrapper getDefaultImageWrapper(String imagePath, int width, int height);
    FlashingImageWrapperDecorator getFlashingImageWrapper(
            ImageWrapper imageWrapper,
            float initialAlpha,
            float alphaStep,
            Color color
    );
}
