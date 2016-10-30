package lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys;

import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactory;
import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.BasicBehaviour;
import lt.Shmup.Main.Graphics.ImageWrapper;

import java.util.Random;

public class BasicEnemyFactory extends EnemyFactory {
    private Random random;

    public BasicEnemyFactory(Random random) {
        this.random = random;
    }

    @Override
    public EntityAwareUpdateable getBehaviour() {
        return new BasicBehaviour(random);
    }

    @Override
    public EntityAwareRenderable getGraphics(
            ImageWrapper imageWrapper
    ) {
        return getRenderableFactory().createImageGraphics(imageWrapper);
    }
}
