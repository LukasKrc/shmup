package lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactorys;


import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
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
    public Updateable getBehaviour() {
        return new RandomMovementBehaviour(this.movementChangeInterval);
    }

    @Override
    public Renderable getGraphics(
            ImageWrapper imageWrapper
    ) {
        return getRenderableFactory().createRotatingImageGraphics(
                imageWrapper,
                rotationStep
        );
    }
}
