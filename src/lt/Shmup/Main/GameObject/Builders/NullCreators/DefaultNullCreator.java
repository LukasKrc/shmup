package lt.Shmup.Main.GameObject.Builders.NullCreators;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.NullHealth;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.NullMovement;
import lt.Shmup.Main.GameObject.Components.Updateables.NullUpdateable;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Components.Renderables.NullRenderable;
import lt.Shmup.Main.GameObject.Updateable;

public class DefaultNullCreator implements lt.Shmup.Main.GameObject.Builders.NullCreator {
    @Override
    public Health getHealth() {
        return new NullHealth();
    }

    @Override
    public Movement getMovement() {
        return new NullMovement();
    }

    @Override
    public Updateable getUpdateable() {
        return new NullUpdateable();
    }

    @Override
    public Renderable getRenderable() {
        return new NullRenderable();
    }
}
