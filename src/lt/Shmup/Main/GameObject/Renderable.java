package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public interface Renderable {
    void render(Graphics2D graphics, Entity entity);
    Renderable clone();
}
