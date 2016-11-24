package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public class NullRenderable implements Renderable {
    @Override
    public void render(Graphics2D graphics, Entity entity) {

    }

    @Override
    public Renderable clone() {
        return this;
    }
}
