package lt.shmup.main.game.gameobject.movement.handlers.decorators;

import lt.shmup.main.Utility;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;
import lt.shmup.main.game.gameobject.movement.handlers.MovementDecorator;

public class OutOfBoundsDecorator extends MovementDecorator {

    private ObjectHandler objectHandler;

    public OutOfBoundsDecorator(
        MovementHandler movementHandler,
        ObjectHandler objectHandler
    ) {
        super(movementHandler);
        this.objectHandler = objectHandler;
    }

    @Override
    public void update(GameObject gameObject) {
        this.getMovementHandler().update(gameObject);

        int gameObjectX = gameObject.getX();
        int gameObjectY = gameObject.getY();
        if (gameObjectX <= 0 || gameObjectX >= Utility.WINDOW_WIDTH) {
            this.objectHandler.removeObject(gameObject);
        }
        if (gameObjectY <= 0 || gameObjectY >= Utility.WINDOW_HEIGHT) {
            this.objectHandler.removeObject(gameObject);
        }
    }
}
