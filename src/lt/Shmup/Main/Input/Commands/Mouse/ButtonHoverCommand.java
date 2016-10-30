package lt.Shmup.Main.Input.Commands.Mouse;

import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.MouseCommand;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.event.MouseEvent;

public class ButtonHoverCommand implements MouseCommand {
    private ButtonEntity entity;

    public ButtonHoverCommand(ButtonEntity entity) {
        this.entity = entity;
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

        if (x > buttonX && x < buttonX + buttonWidth) {
            if (y > buttonY && y < buttonY + buttonHeight) {
                entity.setState(ButtonState.Hovered);
                return;
            }
        }
        entity.setState(ButtonState.Released);
    }

}
