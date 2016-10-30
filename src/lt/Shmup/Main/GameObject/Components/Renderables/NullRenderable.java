package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public class NullRenderable implements EntityAwareRenderable {
    @Override
    public void render(Graphics2D graphics, Entity entity) {

    }

    @Override
    public EntityAwareRenderable clone() {
        return this;
    }
}
