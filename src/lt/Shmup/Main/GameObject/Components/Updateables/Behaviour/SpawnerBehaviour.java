package lt.Shmup.Main.GameObject.Components.Updateables.Behaviour;

import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactory;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.DamageTakenObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ImageFlashObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ProjectileSpawnObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class SpawnerBehaviour implements Updateable {
    private EntityFactory entityFactory;
    private int level = 0;
    private int levelInterval;
    private long lastLevelTime = 0;
    private long lastSpawnTime = 0;
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
        long currentTime = (long) System.currentTimeMillis()/ 1000;
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
    public Updateable clone() {
        return new SpawnerBehaviour(
                entityFactory,
                levelInterval,
                spawnInterval
        );
    }
}
