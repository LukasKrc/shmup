package lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths;

import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.BasicBehaviour;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.Event;

import java.util.HashMap;

public class DeathHealth extends Health {
    public DeathHealth(
        int minimumHealth,
        int maximumHealth,
        int health
    ) {
        super(minimumHealth, maximumHealth, health);
    }

    @Override
    public Health clone() {
        return new DeathHealth(
                getMinimumHealth(),
                getMaximumHealth(),
                getHealth()
        );
    }

    @Override
    public void update(Entity entity) {
        if (this.getHealth() <= this.getMinimumHealth()) {
            if (entity.getIdentifier() == Identifier.Player) {
                Event.notify("player_destroyed", null);
            } else if (entity.getIdentifier() == Identifier.Enemy) {
                HashMap<String, String> data = new HashMap<>();
                if (entity.getBehaviour() instanceof BasicBehaviour) {
                    data.put("score", "50");
                } else {
                    data.put("score", "100");
                }
                Event.notify("enemy_destroyed", data);
            }
            entity.getObjectHandler().removeEntity(entity);
        }
    }
}
