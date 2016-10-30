package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorator;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class ResetDecorator extends MovementDecorator {
    public ResetDecorator(Movement movement) {
        super(movement);
    }

    @Override
    public void update(Entity entity) {
        getMovement().update(entity);
        Position position = entity.getPosition();
        Volume volume = entity.getVolume();
        resetXPositionIfNeeded(position, volume);
        resetYPositionIfNeeded(position, volume);
    }

    private void resetXPositionIfNeeded(Position position, Volume volume) {
        if (position.getX() > volume.getWidth()) {
            position.setX(0);
        } else if (position.getX() < 0) {
            position.setX(volume.getWidth());
        }
    }

    private void resetYPositionIfNeeded(Position position, Volume volume) {
        if (position.getY() > volume.getHeight()) {
            position.setY(0);
        } else if (position.getY() < 0) {
            position.setY(volume.getHeight());
        }
    }

    @Override
    public Movement clone() {
        return new ResetDecorator(getMovement());
    }
}
