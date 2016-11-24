package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

public interface Updateable {
    void update(Entity entity);
    Updateable clone();
}
