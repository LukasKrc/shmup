package lt.Shmup.Main.GameObject.Factories;

import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;
import java.util.HashMap;

public interface RenderableFactory {
    EntityAwareRenderable createBackgroundGraphics(String type);
    EntityAwareRenderable createImageGraphics(ImageWrapper imageWrapper);
    EntityAwareRenderable createRotatingImageGraphics(
            ImageWrapper imageWrapper,
            float rotationStep
    );
    EntityAwareRenderable createHealthBarGraphics(Entity entity);
    HashMap<ButtonState, Color> createButtonStateColors();
    Font getFont(int type, int size);
}
