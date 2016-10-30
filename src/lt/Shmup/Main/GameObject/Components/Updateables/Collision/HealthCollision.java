package lt.Shmup.Main.GameObject.Components.Updateables.Collision;

import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;

public interface HealthCollision {
    void update(DamageCausingEntity entity);
}
