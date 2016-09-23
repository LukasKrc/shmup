package lt.shmup.main.game.input.events.released;

import lt.shmup.main.game.input.events.MovementEvent;

public class MovementReleased extends MovementEvent {

    @Override
    protected int getVelocityY() {
        return 0;
    }

    @Override
    protected int getVelocityX() {
        return 0;
    }

}
