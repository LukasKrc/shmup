package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorator;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Utility;

public abstract class OutOfBoundsDecorator extends MovementDecorator {
    private OutOfBoundsChecker outOfBoundsChecker;
    private boolean xOutOfBounds;
    private boolean yOutOfBounds;
    private boolean isXTouchingBound;
    private boolean isYTouchingBound;

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

    public boolean isXTouchingBound() {
        return isXTouchingBound;
    }

    public boolean isYTouchingBound() {
        return isYTouchingBound;
    }

    @Override
    public void update(Entity entity) {
        Movement movement = getMovement();
        movement.update(entity);
        handleDecoration(entity);
    }

    private void handleDecoration(Entity entity) {
        initializeOutOfBoundsFlags(entity.getPosition());
        initializeTouchingFlags(entity.getPosition(), entity.getVolume());
        decorate(entity);
        xOutOfBounds = yOutOfBounds = false;
    }

    private void initializeOutOfBoundsFlags(Position position) {
        float positionX = position.getX();
        float positionY = position.getY();
        xOutOfBounds = outOfBoundsChecker.isXOutOfBounds(positionX);
        yOutOfBounds = outOfBoundsChecker.isYOutOfBounds(positionY);
    }

    private void initializeTouchingFlags(Position position, Volume volume) {
        isXTouchingBound = position.getX() <= 0
                || position.getX() + volume.getWidth() >= Utility.WINDOW_WIDTH;
        isYTouchingBound = position.getY() <= 0
                || position.getY() + volume.getHeight() >= Utility.WINDOW_HEIGHT;
    }

    public abstract void decorate(Entity entity);
}
