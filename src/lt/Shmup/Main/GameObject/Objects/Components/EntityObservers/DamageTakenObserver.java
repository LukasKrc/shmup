package lt.Shmup.Main.GameObject.Objects.Components.EntityObservers;

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.HashMap;

public class DamageTakenObserver implements EntityObserver {
    @Override
    public void notify(Entity entity, String eventName, HashMap<String, String> data) {
        if (eventName == "damage_taken") {
            Health health = entity.getHealth();
            int damage = Integer.parseInt(data.get("damage"));
            health.setHealth(health.getHealth() - damage);
        }
    }

    @Override
    public EntityObserver clone() {
        return new DamageTakenObserver();
    }
}
