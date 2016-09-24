package lt.shmup.main.game.gameobject.movement.handlers;

import lt.shmup.main.game.gameobject.movement.MovementHandler;

public abstract class MovementDecorator implements MovementHandler {

    private MovementHandler movementHandler;

    protected MovementDecorator() {

    }

    public MovementDecorator(MovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }

    public MovementHandler getMovementHandler() {
        return this.movementHandler;
    }

    public void setMovementHandler(MovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }
}
