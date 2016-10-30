package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components;

public interface OutOfBoundsChecker {
    boolean isXOutOfBounds(float x);
    boolean isYOutOfBounds(float y);
}
