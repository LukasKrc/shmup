package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements;

import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;

public abstract class MovementDecorator extends Movement {
    private Movement movement;

    public MovementDecorator(Movement movement) {
        super(0, 0);
        this.movement = movement;
    }

    public Movement getMovement() {
        return this.movement;
    }

    @Override
    public float getSpeedX() {
        return movement.getSpeedX();
    }

    @Override
    public void setSpeedX(float speedX) {
            movement.setSpeedX(speedX);
    }

    @Override
    public float getSpeedY() {
        return movement.getSpeedY();
    }

    @Override
    public void setSpeedY(float speedY) {
        movement.setSpeedY(speedY);
    }
}
