package lt.Shmup.Main.GameObject.Factories.Entity;

import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;

public interface ProjectileFactory {
    Entity getProjectile(Identifier identifier);
}
