package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public interface EntityAwareRenderable {
    void render(Graphics2D graphics, Entity entity);
    EntityAwareRenderable clone();
}
