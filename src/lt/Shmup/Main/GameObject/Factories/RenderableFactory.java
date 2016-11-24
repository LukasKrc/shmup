package lt.Shmup.Main.GameObject.Factories;

import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.awt.*;
import java.util.HashMap;

public interface RenderableFactory {
    Renderable createBackgroundGraphics(String type);
    Renderable createImageGraphics(ImageWrapper imageWrapper);
    Renderable createRotatingImageGraphics(
            ImageWrapper imageWrapper,
            float rotationStep
    );
    Renderable createHealthBarGraphics(Entity entity);
    HashMap<ButtonState, Color> createButtonStateColors();
    Font getFont(int type, int size);
}
