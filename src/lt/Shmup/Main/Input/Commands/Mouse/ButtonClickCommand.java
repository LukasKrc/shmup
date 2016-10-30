package lt.Shmup.Main.Input.Commands.Mouse;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.MouseCommand;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.event.MouseEvent;

public class ButtonClickCommand implements MouseCommand {
    private Entity entity;
    private Command mediatorCommand;

    public ButtonClickCommand(Entity entity, Command mediatorCommand) {
        this.entity = entity;
        this.mediatorCommand = mediatorCommand;
    }

    @Override
    public void execute(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Position position = entity.getPosition();
        Volume volume = entity.getVolume();
        float buttonX = position.getX();
        float buttonY = position.getY();
        float buttonWidth = volume.getWidth();
        float buttonHeight = volume.getHeight();

        if (!(x > buttonX && x < buttonX + buttonWidth)) {
            return;
        }

        if (y > buttonY && y < buttonY + buttonHeight) {
            mediatorCommand.execute();
        }
    }

}
