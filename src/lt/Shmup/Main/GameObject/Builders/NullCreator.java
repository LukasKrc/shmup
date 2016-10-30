package lt.Shmup.Main.GameObject.Builders;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;

public interface NullCreator {
    Health getHealth();
    Movement getMovement();
    EntityAwareUpdateable getUpdateable();
    EntityAwareRenderable getRenderable();
}
