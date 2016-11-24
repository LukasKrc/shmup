package lt.Shmup.Main.GameObject.Components.Updateables.Behaviour;

import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;

import java.util.Random;

public class BasicBehaviour implements Updateable {
    private Random randomGenerator;
    private int lastMovementChangeTime;
    private int movementChangeInterval;

    public BasicBehaviour(Random randomGenerator) {
        this.lastMovementChangeTime = (int) System.currentTimeMillis() / 1000;
        this.randomGenerator = randomGenerator;
        this.movementChangeInterval = randomGenerator.nextInt(10);
    }

    @Override
    public void update(Entity entity) {
        boolean directionChanged =
            this.changeMovementDirectionIfNeeded(entity);
        if (!directionChanged) {
            return;
        }

        this.fireProjectile(entity);
    }

    @Override
    public Updateable clone() {
        return new BasicBehaviour(randomGenerator);
    }

    private boolean changeMovementDirectionIfNeeded(Entity entity) {
        boolean decision = randomGenerator.nextBoolean();
        Movement movement = entity.getMovement();
        int currentTimeInSeconds = (int) (System.currentTimeMillis() / 1000);
        int movementTimeDelta =
                currentTimeInSeconds - this.lastMovementChangeTime;
        if (decision && movementTimeDelta > movementChangeInterval) {
            movement.setSpeedX(-movement.getSpeedX());
            this.lastMovementChangeTime = currentTimeInSeconds;

            return true;
        }

        return false;
    }

    private void fireProjectile(Entity entity) {
        entity.notifyObservers("projectile_fired", null);
    }
}
