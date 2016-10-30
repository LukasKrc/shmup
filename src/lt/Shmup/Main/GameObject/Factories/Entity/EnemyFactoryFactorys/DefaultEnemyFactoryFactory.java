package lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactoryFactorys;


import lt.Shmup.Config;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactoryFactory;
import lt.Shmup.Main.GameObject.Factories.RenderableFactorys.DefaultRenderableFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys.BasicEnemyFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys.RandomEnemyFactory;

import java.util.Random;

public class DefaultEnemyFactoryFactory implements EnemyFactoryFactory {
    private int randomEnemyMovementInterval;
    private float randomEnemyRotationStep;
    private Random random;

    public DefaultEnemyFactoryFactory() {
        randomEnemyMovementInterval = Config.intg(
                "game/movements/enemies/random/direction_change_interval"
        );
        randomEnemyRotationStep = Config.flt(
                "graphics/images/entities/enemy/random/rotation_step"
        );
        random = new Random();
    }

    @Override
    public EnemyFactory getFactory(String type) {
        switch (type) {
            case "basic" :
                return new BasicEnemyFactory(random);
            case "random" :
                return new RandomEnemyFactory(
                        randomEnemyMovementInterval,
                        randomEnemyRotationStep
                );
        }

        throw new RuntimeException(
                "Enemy Factories of type " + type + " does not exist."
        );
    }
}
