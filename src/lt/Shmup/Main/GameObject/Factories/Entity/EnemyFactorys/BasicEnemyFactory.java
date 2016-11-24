package lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys;

import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
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
    public Updateable getBehaviour() {
        return new BasicBehaviour(random);
    }

    @Override
    public Renderable getGraphics(
            ImageWrapper imageWrapper
    ) {
        return getRenderableFactory().createImageGraphics(imageWrapper);
    }
}
