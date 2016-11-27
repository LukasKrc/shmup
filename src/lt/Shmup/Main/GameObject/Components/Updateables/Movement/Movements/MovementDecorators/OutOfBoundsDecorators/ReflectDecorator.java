package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators;

import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorator;

public class ReflectDecorator extends OutOfBoundsDecorator {
    public ReflectDecorator(Movement movement, OutOfBoundsChecker outOfBoundsChecker) {
        super(movement, outOfBoundsChecker);
    }

    @Override
    public void decorate(Entity entity) {
        Movement movement = getMovement();
        if (isXTouchingBound()) {
            movement.setSpeedX(-movement.getSpeedX());
        }
        if (isYTouchingBound()) {
            movement.setSpeedY(-movement.getSpeedY());
        }
    }

    @Override
    public Movement clone() {
        return new ReflectDecorator(
                getMovement().clone(),
                getOutOfBoundsChecker()
        );
    }
}
