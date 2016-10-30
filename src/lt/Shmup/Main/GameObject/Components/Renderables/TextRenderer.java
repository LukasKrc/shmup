package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;

import java.awt.*;

public interface TextRenderer {
    void render(Graphics2D graphics, TextEntity entity);
}
