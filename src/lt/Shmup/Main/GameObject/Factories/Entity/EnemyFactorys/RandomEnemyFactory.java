package lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys;


import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactory;
import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.RandomMovementBehaviour;
import lt.Shmup.Main.Graphics.ImageWrapper;

public class RandomEnemyFactory extends EnemyFactory {
    private int movementChangeInterval;
    private float rotationStep;

    public RandomEnemyFactory(int movementChangeInterval, float rotationStep) {
        this.movementChangeInterval = movementChangeInterval;
        this.rotationStep = rotationStep;
    }

    @Override
    public EntityAwareUpdateable getBehaviour() {
        return new RandomMovementBehaviour(this.movementChangeInterval);
    }

    @Override
    public EntityAwareRenderable getGraphics(
            ImageWrapper imageWrapper
    ) {
        return getRenderableFactory().createRotatingImageGraphics(
                imageWrapper,
                rotationStep
        );
    }
}
