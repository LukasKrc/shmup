package lt.Shmup.Main.GameObject.Components.Updateables.Behaviour;

import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;

import java.util.Random;

public class RandomMovementBehaviour implements Updateable {
    private int movementChangeInterval;
    private int lastMovementChangeTime;
    private Random random = new Random();

    public RandomMovementBehaviour(int movementChangeInterval) {
        this.movementChangeInterval = movementChangeInterval;
        this.lastMovementChangeTime = (int) System.currentTimeMillis() / 1000;
    }

    @Override
    public void update(Entity entity) {
        Movement movement = entity.getMovement();
        int currentTimeInSeconds = (int) System.currentTimeMillis() / 1000;
        if ((currentTimeInSeconds - this.lastMovementChangeTime) > this.movementChangeInterval) {
            randomlyChangeMovementDirection(movement);
            this.lastMovementChangeTime = currentTimeInSeconds;
        }
    }

    @Override
    public Updateable clone() {
        return new RandomMovementBehaviour(movementChangeInterval);
    }

    private void randomlyChangeMovementDirection(Movement movement) {
        float randomAngle = (float) (random.nextFloat() * 2 * Math.PI);
        float speedX = movement.getSpeedX();
        float speedY = movement.getSpeedY();
        float changedSpeedX = (float) (speedX * Math.cos(randomAngle) - speedY * Math.sin(randomAngle));
        float changedSpeedY = (float) (speedX * Math.sin(randomAngle) + speedY * Math.cos(randomAngle));
        movement.setSpeedX(changedSpeedX);
        movement.setSpeedY(changedSpeedY);
    }
}
