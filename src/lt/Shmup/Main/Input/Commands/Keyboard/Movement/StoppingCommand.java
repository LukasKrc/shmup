package lt.Shmup.Main.Input.Commands.Keyboard.Movement;

import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Input.KeyState;

public abstract class StoppingCommand implements Command {
    private Entity entity;
    private KeyState keyState;
    private int oppositeKeyCode;
    private Command oppositeKeyCommand;

    public StoppingCommand(
            Entity entity,
            KeyState keyState,
            int oppositeKeyCode,
            Command oppositeKeyCommand
    ) {
        this.entity = entity;
        this.keyState = keyState;
        this.oppositeKeyCode = oppositeKeyCode;
        this.oppositeKeyCommand = oppositeKeyCommand;
    }

    @Override
    public void execute() {
        if (this.keyState.isKeyPressed(this.oppositeKeyCode)) {
            this.oppositeKeyCommand.execute();
            return;
        }
        this.setVelocity(entity.getMovement());
    }

    public abstract void setVelocity(Movement movement);
}
