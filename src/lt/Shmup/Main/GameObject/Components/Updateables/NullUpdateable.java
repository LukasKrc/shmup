package lt.Shmup.Main.GameObject.Components.Updateables;

import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class NullUpdateable implements Updateable {
    @Override
    public void update(Entity entity) {

    }

    @Override
    public Updateable clone() {
        return this;
    }
}
