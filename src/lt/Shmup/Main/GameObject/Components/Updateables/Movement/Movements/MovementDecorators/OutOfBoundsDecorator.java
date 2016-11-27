package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorator;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;

public abstract class OutOfBoundsDecorator extends MovementDecorator {
    private OutOfBoundsChecker outOfBoundsChecker;
    private boolean xOutOfBounds;
    private boolean yOutOfBounds;

    public OutOfBoundsDecorator(
        Movement movement,
        OutOfBoundsChecker outOfBoundsChecker
    ) {
        super(movement);
        this.outOfBoundsChecker = outOfBoundsChecker;
    }

    public OutOfBoundsChecker getOutOfBoundsChecker() {
        return outOfBoundsChecker;
    }

    public boolean isxOutOfBounds() {
        return xOutOfBounds;
    }

    public boolean isyOutOfBounds() {
        return yOutOfBounds;
    }

    @Override
    public void update(Entity entity) {
        Movement movement = getMovement();
        movement.update(entity);
        handleDecoration(entity);
    }

    private void handleDecoration(Entity entity) {
        initializeOutOfBoundsFlags(entity.getPosition(), entity.getVolume());
        decorate(entity);
        xOutOfBounds = yOutOfBounds = false;
    }

    private void initializeOutOfBoundsFlags(Position position, Volume volume) {
        float positionX = position.getX();
        float positionY = position.getY();
        xOutOfBounds = outOfBoundsChecker.isXOutOfBounds(positionX)
            || outOfBoundsChecker.isXOutOfBounds(positionX + volume.getWidth());
        yOutOfBounds = outOfBoundsChecker.isYOutOfBounds(positionY)
            || outOfBoundsChecker.isYOutOfBounds(positionY + volume.getHeight());
    }

    public abstract void decorate(Entity entity);
}
