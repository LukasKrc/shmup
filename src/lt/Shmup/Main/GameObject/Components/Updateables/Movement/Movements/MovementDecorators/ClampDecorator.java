package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorator;
import lt.Shmup.Utility;

public class ClampDecorator extends MovementDecorator {
    public ClampDecorator(Movement movement) {
        super(movement);
    }

    @Override
    public void update(Entity entity) {
        Movement movement = getMovement();
        movement.update(entity);
        clampPositionValues(entity.getPosition());
    }

    private void clampPositionValues(Position position) {
        float x = position.getX();
        float y = position.getY();
        position.setX(Utility.clampFlt(x, 0, Utility.WINDOW_WIDTH));
        position.setY(Utility.clampFlt(y, 0, Utility.WINDOW_HEIGHT));
    }

    @Override
    public Movement clone() {
        return new ClampDecorator(getMovement().clone());
    }
}
