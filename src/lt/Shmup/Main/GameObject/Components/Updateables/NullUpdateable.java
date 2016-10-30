package lt.Shmup.Main.GameObject.Components.Updateables;

import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class NullUpdateable implements EntityAwareUpdateable {
    @Override
    public void update(Entity entity) {

    }

    @Override
    public EntityAwareUpdateable clone() {
        return this;
    }
}
