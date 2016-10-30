package lt.Shmup.Main.Input.Commands.Keyboard.Movement.Pressed;


import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.MovementCommand;

public class MovementHorizontalCommand extends MovementCommand {
    public MovementHorizontalCommand(Entity entity, int speed) {
        super(entity, speed);
    }

    @Override
    public void execute() {
        getEntity().getMovement().setSpeedX(getSpeed());
    }
}
