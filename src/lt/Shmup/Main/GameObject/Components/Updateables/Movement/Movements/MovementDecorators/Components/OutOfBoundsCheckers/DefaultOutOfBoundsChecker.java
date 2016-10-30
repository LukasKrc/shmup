package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsCheckers;

import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Utility;

public class DefaultOutOfBoundsChecker implements OutOfBoundsChecker {
    @Override
    public boolean isXOutOfBounds(float x) {
        return x <= 0 || x >= Utility.WINDOW_WIDTH;
    }

    @Override
    public boolean isYOutOfBounds(float y) {
        return y <= 0 || y >= Utility.WINDOW_HEIGHT;
    }
}
