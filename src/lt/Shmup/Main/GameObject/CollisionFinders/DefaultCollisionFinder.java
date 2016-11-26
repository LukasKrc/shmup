package lt.Shmup.Main.GameObject.CollisionFinders;

import lt.Shmup.Main.GameObject.CollisionFinder;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;

import java.awt.*;
import java.util.LinkedList;

public class DefaultCollisionFinder implements CollisionFinder {
    private LinkedList<Entity> entities = new LinkedList<>();

    @Override
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    @Override
    public LinkedList<Entity> getCollidedEntities(Entity mainEntity) {
        if (!mainEntity.isCollidable()) {
            return new LinkedList<>();
        }
        LinkedList<Entity> collidedEntities = new LinkedList<>();
        for (Entity entity : this.entities) {
            addToCollidedIfNeeded(mainEntity, collidedEntities, entity);
        }

        return collidedEntities;
    }

    private void addToCollidedIfNeeded(Entity mainEntity, LinkedList<Entity> collidedEntities, Entity entity) {
        if (!shouldEntityBeAdded(mainEntity, entity)) {
            return;
        }
        if (doEntitiesIntersect(mainEntity, entity)) {
            collidedEntities.add(entity);
        }
    }

    private boolean doEntitiesIntersect(Entity mainEntity, Entity entity) {
        return entity.getBounds().intersects(
                mainEntity.getBounds()
        ) || areEntitiesTouching(mainEntity, entity);
    }

    private boolean areEntitiesTouching(Entity mainEntity, Entity entity) {
        Rectangle mainBounds = getIncreasedBounds(mainEntity);
        Rectangle secondaryBounds = getIncreasedBounds(entity);
        return mainBounds.intersects(secondaryBounds);
    }

    private Rectangle getIncreasedBounds(Entity entity) {
        Position position = entity.getPosition();
        Volume volume = entity.getVolume();
        return new Rectangle(
                (int) position.getX() + 1,
                (int) position.getY() + 1,
                (int) volume.getWidth() + 1,
                (int) volume.getHeight() + 1
        );
    }

    private boolean shouldEntityBeAdded(Entity mainEntity, Entity entity) {
        if (
                mainEntity == entity
                || !this.shouldCollide(entity, mainEntity)
                || !entity.isCollidable()
        ) {
            return false;
        }
        return true;
    }

    private boolean shouldCollide(Entity collidedEntity, Entity mainEntity) {
        return !(
            didFriendlyEntitiesCollide(
                collidedEntity,
                mainEntity,
                Identifier.Player,
                Identifier.PlayerProjectile
            )
            || didFriendlyEntitiesCollide(
                collidedEntity,
                mainEntity,
                Identifier.Enemy,
                Identifier.EnemyProjectile
            )
            || didIdenticalEntitiesCollide(
                collidedEntity,
                mainEntity,
                Identifier.Enemy
            )
        );
    }

    private boolean didFriendlyEntitiesCollide(
        Entity firstEntity,
        Entity secondEntity,
        Identifier firstIdentifier,
        Identifier secondIdentifier
    ) {
        Identifier firstEntityIdentifier = firstEntity.getIdentifier();
        Identifier secondEntityIdentifier = secondEntity.getIdentifier();
        return (firstEntityIdentifier == firstIdentifier
                && secondEntityIdentifier == secondIdentifier)
                || (firstEntityIdentifier == secondIdentifier
                && secondEntityIdentifier == firstIdentifier);
    }

    private boolean didIdenticalEntitiesCollide(
        Entity collidedEntity,
        Entity mainEntity,
        Identifier identifier
    ) {
        return collidedEntity.getIdentifier() == identifier
            && mainEntity.getIdentifier() == identifier;
    }
}
