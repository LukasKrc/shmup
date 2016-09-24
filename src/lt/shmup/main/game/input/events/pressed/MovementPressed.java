package lt.shmup.main.game.input.events.pressed;

import lt.shmup.main.game.input.events.MovementEvent;

public class MovementPressed extends MovementEvent {

    private int velocityX;

    private int velocityY;

    public MovementPressed(int velocityX, int velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    @Override
    protected int getVelocityY() {
        return this.velocityY;
    }

    @Override
    protected int getVelocityX() {
        return this.velocityX;
    }
}
