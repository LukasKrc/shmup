package lt.shmup.main.game.input.commands.movement.pressed;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.gameobject.GameObject;

public class MoveLeft implements Command {

    private GameObject gameObject;

    private int velocity;

    public MoveLeft(GameObject gameObject, int velocity) {
        this.gameObject = gameObject;
        this.velocity = velocity;
    }

    @Override
    public void execute() {
        this.gameObject.setVelocityX(-this.velocity);
    }
}
