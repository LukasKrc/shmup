package lt.Shmup.Main.Graphics.ImageWrappers;

import lt.Shmup.Main.Graphics.ImageWrapper;

public abstract class ImageWrapperDecorator extends ImageWrapper {
    private ImageWrapper imageWrapper;

    public ImageWrapperDecorator(ImageWrapper imageWrapper) {
        super(null, 0, 0);
        this.imageWrapper = imageWrapper;
    }

    public ImageWrapper getImageWrapper() {
        return imageWrapper;
    }

    @Override
    public int getWidth() {
        return imageWrapper.getWidth();
    }

    @Override
    public void setWidth(int width) {
        imageWrapper.setWidth(width);
    }

    @Override
    public int getHeight() {
        return imageWrapper.getHeight();
    }

    @Override
    public void setHeight(int height) {
        imageWrapper.setHeight(height);
    }

}
