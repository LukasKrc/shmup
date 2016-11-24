package lt.Shmup.Main.GameObject.Builders;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;

public interface NullCreator {
    Health getHealth();
    Movement getMovement();
    Updateable getUpdateable();
    Renderable getRenderable();
}
