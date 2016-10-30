package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;
import java.util.Collection;

public interface ObjectHandler {
    CollisionFinder getCollisionFinder();
    void update();
    void render(Graphics2D graphics);
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    void addEntities(Collection entities);
}
