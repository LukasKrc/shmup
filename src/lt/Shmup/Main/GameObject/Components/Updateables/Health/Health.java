package lt.Shmup.Main.GameObject.Components.Updateables.Health;

import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;

public abstract class Health implements EntityAwareUpdateable {
    private int minimumHealth, maximumHealth, health;

    public Health(int minimumHealth, int maximumHealth, int health) {
        this.minimumHealth = minimumHealth;
        this.maximumHealth = maximumHealth;
        this.health = health;
    }

    public int getMinimumHealth() {
        return minimumHealth;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract Health clone();
}
