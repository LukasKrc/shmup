package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.LinkedList;

public interface CollisionFinder {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    LinkedList<Entity> getCollidedEntities(Entity mainEntity);
}
