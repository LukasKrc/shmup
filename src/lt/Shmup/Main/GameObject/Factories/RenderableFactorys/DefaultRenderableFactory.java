package lt.Shmup.Main.GameObject.Factories.RenderableFactorys;

import lt.Shmup.Config;
import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactory;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.TextCenterer;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Components.Renderables.*;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;
import java.util.HashMap;

public class DefaultRenderableFactory implements lt.Shmup.Main.GameObject.Factories.RenderableFactory {
    private String defaultFontName;
    private HashMap<ButtonState, Color> textStateColors;
    private ImageWrapperFactory imageWrapperFactory;

    private int defaultRedValueReleased = 150;
    private int defaultGreenValueReleased = 100;
    private int defaultBlueValueReleased = 150;

    private int defaultRedValueHovered = 183;
    private int defaultGreenValueHovered = 109;
    private int defaultBlueValueHovered = 214;

    private int defaultRedValueDepressed = 81;
    private int defaultGreenValueDepressed = 54;
    private int defaultBlueValueDepressed = 92;

    public DefaultRenderableFactory(
            ImageWrapperFactory imageWrapperFactory
    ) {
        this.defaultFontName = Config.str("graphics/common/font");
        this.imageWrapperFactory = imageWrapperFactory;
    }

    @Override
    public EntityAwareRenderable createBackgroundGraphics() {
        int width =
                Config.intg("graphics/images/menu_background/width");
        int height =
                Config.intg("graphics/images/menu_background/height");
        String backgroundImagePath =
                Config.str("graphics/images/menu_background/path");
        ImageWrapper imageWrapper = imageWrapperFactory
                .getDefaultImageWrapper(backgroundImagePath, width, height);

        return new ScrollingBackgroundGraphics(imageWrapper);
    }

    @Override
    public EntityAwareRenderable createImageGraphics(
            ImageWrapper imageWrapper
    ) {
        return new ImageGraphics(imageWrapper);
    }

    @Override
    public EntityAwareRenderable createRotatingImageGraphics(
            ImageWrapper imageWrapper,
            float rotationStep
    ) {
        return new RotatingImageGraphics(imageWrapper, rotationStep);
    }

    @Override
    public EntityAwareRenderable createHealthBarGraphics(Entity entity) {
        return new HealthBarGraphics(entity);
    }

    @Override
    public HashMap<ButtonState, Color> createButtonStateColors() {
        if (textStateColors == null) {
            textStateColors = new HashMap<>();
            Color defaultColor = new Color(
                    this.defaultRedValueReleased,
                    this.defaultGreenValueReleased,
                    this.defaultBlueValueReleased
            );
            textStateColors.put(ButtonState.Released, defaultColor);
            textStateColors.put(ButtonState.Hovered, new Color(
                            this.defaultRedValueHovered,
                            this.defaultGreenValueHovered,
                            this.defaultBlueValueHovered
                    )
            );
            textStateColors.put(ButtonState.Depressed, new Color(
                            this.defaultRedValueDepressed,
                            this.defaultGreenValueDepressed,
                            this.defaultBlueValueDepressed
                    )
            );
        }
        return textStateColors;
    }

    @Override
    public Font getFont(int type, int size) {
        return new Font(defaultFontName, type, size);
    }
}
