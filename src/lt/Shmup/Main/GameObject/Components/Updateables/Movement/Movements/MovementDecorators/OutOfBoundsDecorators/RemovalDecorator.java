package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators;

import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorator;

public class RemovalDecorator extends OutOfBoundsDecorator {
    private ObjectHandler objectHandler;

    public RemovalDecorator(
        Movement movement,
        OutOfBoundsChecker outOfBoundsChecker,
        ObjectHandler objectHandler
    ) {
        super(movement, outOfBoundsChecker);
        this.objectHandler = objectHandler;
    }

    /**
     * Removes renderable and updateable Objects
     * for entity that is out of bounds.
     */
    @Override
    public void decorate(Entity entity) {
        if (isxOutOfBounds() || isyOutOfBounds()) {
            objectHandler.removeEntity(entity);
        }
    }

    @Override
    public Movement clone() {
        return new RemovalDecorator(
                getMovement().clone(),
                getOutOfBoundsChecker(),
                objectHandler
        );
    }
}
