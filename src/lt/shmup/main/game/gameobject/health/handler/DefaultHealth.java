package lt.shmup.main.game.gameobject.health.handler;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.health.HealthHandler;

public class DefaultHealth extends HealthHandler {

    public DefaultHealth(int minimumHealth, int maximumHealth, int health) {
        super(minimumHealth, maximumHealth, health);
    }

    @Override
    public void update(GameObject gameObject) {
        // Do nothing.
    }

}
