package lt.shmup.main.game.gameobject.health;

import lt.shmup.main.game.gameobject.GameObject;

public abstract class HealthHandler {

    private int minimumHealth, maximumHealth, health;

    public HealthHandler(int minimumHealth, int maximumHealth, int health) {
        this.minimumHealth = minimumHealth;
        this.maximumHealth = maximumHealth;
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMinimumHealth() {
        return minimumHealth;
    }

    public void setMinimumHealth(int minimumHealth) {
        this.minimumHealth = minimumHealth;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public abstract void update(GameObject gameObject);
}
