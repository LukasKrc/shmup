package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements;

import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class NullMovement extends Movement {
    public NullMovement() {
        super(0, 0);
    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public Movement clone() {
        return this;
    }
}
