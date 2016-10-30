package lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.HashMap;

public class NullHealth extends Health {
    public NullHealth() {
        super(0, 0, 0);
    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public Health clone() {
        return this;
    }
}
