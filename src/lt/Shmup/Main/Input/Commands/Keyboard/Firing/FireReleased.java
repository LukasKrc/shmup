package lt.Shmup.Main.Input.Commands.Keyboard.Firing;

import lt.Shmup.Main.Command.Command;

public class FireReleased implements Command {
    private FirePressed firePressedCommand;

    public FireReleased(FirePressed firePressedCommand) {
        this.firePressedCommand = firePressedCommand;
    }

    @Override
    public void execute() {
        this.firePressedCommand.setKeyPressed(false);
    }
}
