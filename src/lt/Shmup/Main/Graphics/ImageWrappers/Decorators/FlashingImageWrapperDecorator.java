package lt.Shmup.Main.Graphics.ImageWrappers.Decorators;

import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Utility;
import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Main.Graphics.ImageWrappers.ImageWrapperDecorator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class FlashingImageWrapperDecorator extends ImageWrapperDecorator {
    private float alphaValueStep;
    private float initialAlphaValue;
    Color color;
    private float alphaValue = 0;

    public FlashingImageWrapperDecorator(
        ImageWrapper imageWrapper,
        float alphaValueStep,
        float initialAlphaValue,
        Color color
    ) {
        super(imageWrapper);
        this.alphaValueStep = alphaValueStep;
        this.initialAlphaValue = initialAlphaValue;
        this.color = color;
    }

    public void resetAlpha() {
        this.alphaValue = this.initialAlphaValue;
    }

    @Override
    public Image getImage() {
        updateAlphaValue();
        ImageWrapper imageWrapper = getImageWrapper();
        Image image = imageWrapper.getImage();
        int width = getImageWrapper().getWidth();
        int height = getImageWrapper().getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage bufferedImage = this.getBufferedImage(image, width, height);
        drawOverlay(bufferedImage, result, width, height);

        return result;
    }

    private void drawOverlay(
        BufferedImage bufferedImage,
        BufferedImage originalImage,
        int width,
        int height
    ) {
        Graphics2D overlayGraphics = originalImage.createGraphics();
        overlayGraphics.drawImage(bufferedImage, 0, 0, null);
        overlayGraphics.setColor(color);
        overlayGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, this.alphaValue));
        overlayGraphics.fillRect(0, 0, width, height);
    }

    private BufferedImage getBufferedImage(Image image, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D bufferGraphics = bufferedImage.createGraphics();
        bufferGraphics.drawImage(image, 0, 0, null);
        bufferGraphics.dispose();

        return bufferedImage;
    }

    private void updateAlphaValue() {
        alphaValue += alphaValueStep;
        alphaValue = Utility.clampFlt(alphaValue, 0, 1);
    }

    @Override
    public ImageWrapper clone() {
        return new FlashingImageWrapperDecorator(
                getImageWrapper(),
                alphaValueStep,
                initialAlphaValue,
                color
        );
    }
}
