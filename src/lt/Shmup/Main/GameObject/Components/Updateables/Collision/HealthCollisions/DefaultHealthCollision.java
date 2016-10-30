package lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions;


import lt.Shmup.Main.GameObject.CollisionFinder;
import lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollision;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.HashMap;
import java.util.LinkedList;

public class DefaultHealthCollision implements HealthCollision {
    @Override
    public void update(DamageCausingEntity entity) {
        CollisionFinder collisionFinder =
                entity.getObjectHandler().getCollisionFinder();
        LinkedList<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(entity);
        for (Entity collidedEntity : collidedEntities) {
            this.handleGameObjectCollision(collidedEntity, entity);
        }
    }

    private void handleGameObjectCollision(
        Entity collidedEntity,
        DamageCausingEntity mainEntity
    ) {
        if (mainEntity.getIdentifier() == Identifier.PlayerProjectile
            || mainEntity.getIdentifier() == Identifier.EnemyProjectile
        ) {
            this.handleProjectileCollision(collidedEntity, mainEntity);
        }

        if (mainEntity.getIdentifier() == Identifier.Player
            || mainEntity.getIdentifier() == Identifier.Enemy
        ) {
            this.handleCharacterCollision(
                    collidedEntity,
                    getEntityCollisionDamageData(mainEntity)
            );
        }
    }

    private void handleProjectileCollision(
            Entity collidedEntity,
            DamageCausingEntity projectile
    ) {
        projectile.notifyObservers(
                "damage_taken",
                getProjectileSelfDamageData()
        );
        handleCharacterCollision(
                collidedEntity,
                getEntityCollisionDamageData(projectile)
        );
    }

    private HashMap<String, String> getProjectileSelfDamageData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("damage", "1");
        return data;
    }

    private HashMap<String, String> getEntityCollisionDamageData(
            DamageCausingEntity entity
    ) {
        HashMap<String, String> data = new HashMap<>();
        data.put("damage", String.valueOf(entity.getCollisionDamage()));
        return data;
    }

    private void handleCharacterCollision(
            Entity collidedEntity,
            HashMap<String, String> damageData
    ) {
        collidedEntity.notifyObservers("damage_taken", damageData);
    }
}
