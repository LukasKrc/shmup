package lt.Shmup.Main.GameObject.Components.Updateables.Behaviour;

import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactory;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.DamageTakenObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ImageFlashObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ProjectileSpawnObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.LinkedList;

public class SpawnerBehaviour implements EntityAwareUpdateable {
    private EntityFactory entityFactory;
    private int level = 0;
    private int levelInterval;
    private int lastLevelTime = 0;
    private int lastSpawnTime = 0;
    private int spawnInterval;

    public SpawnerBehaviour(
            EntityFactory entityFactory,
            int levelInterval,
            int spawnInterval
    ) {
        this.entityFactory = entityFactory;
        this.levelInterval = levelInterval;
        this.spawnInterval = spawnInterval;
    }

    @Override
    public void update(Entity entity) {
        int currentTime = (int) System.currentTimeMillis()/ 1000;
        if ((currentTime - lastLevelTime) > levelInterval) {
            level++;
            lastLevelTime = currentTime;
        }
        if ((currentTime - lastSpawnTime) > spawnInterval) {
            for (int i = 0; i <= level; i++) {
                ObjectHandler objectHandler = entity.getObjectHandler();
                DamageCausingEntity basicEnemy = entityFactory.getBasicEnemy();
                DamageCausingEntity randomEnemy = entityFactory.getRandomEnemy();
                attachObservers(basicEnemy, randomEnemy);
                objectHandler.addEntity(basicEnemy);
                objectHandler.addEntity(basicEnemy.clone());
                objectHandler.addEntity(randomEnemy);
            }
            lastSpawnTime = currentTime;
        }
    }

    private void attachObservers(Entity basicEnemy, Entity randomEnemy) {
        basicEnemy.attachObserver(new ProjectileSpawnObserver());
        basicEnemy.attachObserver(new ImageFlashObserver());
        basicEnemy.attachObserver(new DamageTakenObserver());
        randomEnemy.attachObserver(new ImageFlashObserver());
        randomEnemy.attachObserver(new DamageTakenObserver());
    }

    @Override
    public EntityAwareUpdateable clone() {
        return new SpawnerBehaviour(
                entityFactory,
                levelInterval,
                spawnInterval
        );
    }
}
