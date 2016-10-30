package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;

public class LinearMovement extends Movement {
    public LinearMovement(float speedX, float speedY) {
        super(speedX, speedY);
    }

    @Override
    public Movement clone() {
        return new LinearMovement(getSpeedX(), getSpeedY());
    }

    @Override
    public void update(Entity entity) {
        Position position = entity.getPosition();
        updatePosition(position);
    }

    private void updatePosition(Position position) {
        float x = position.getX();
        float y = position.getY();
        position.setX(x + getSpeedX());
        position.setY(y + getSpeedY());
    }
}
