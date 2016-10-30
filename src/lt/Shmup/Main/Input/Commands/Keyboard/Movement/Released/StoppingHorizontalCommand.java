package lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Input.KeyState;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.StoppingCommand;

public class StoppingHorizontalCommand extends StoppingCommand {
    public StoppingHorizontalCommand(
        Entity entity,
        KeyState keyState,
        int oppositeKeyCode,
        Command oppositeKeyCommand
    ) {
        super(entity, keyState, oppositeKeyCode, oppositeKeyCommand);
    }

    @Override
    public void setVelocity(Movement movement) {
        movement.setSpeedX(0);
    }
}
