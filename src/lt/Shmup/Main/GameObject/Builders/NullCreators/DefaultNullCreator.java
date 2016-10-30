package lt.Shmup.Main.GameObject.Builders.NullCreators;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.NullHealth;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.NullMovement;
import lt.Shmup.Main.GameObject.Components.Updateables.NullUpdateable;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Components.Renderables.NullRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;

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
    public EntityAwareUpdateable getUpdateable() {
        return new NullUpdateable();
    }

    @Override
    public EntityAwareRenderable getRenderable() {
        return new NullRenderable();
    }
}
