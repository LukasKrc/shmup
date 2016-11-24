package lt.Shmup.Main.GameObject.Components.Updateables.Health;

import lt.Shmup.Main.GameObject.Updateable;

public abstract class Health implements Updateable {
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
