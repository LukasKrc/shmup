package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

public interface EntityAwareUpdateable {
    void update(Entity entity);
    EntityAwareUpdateable clone();
}
