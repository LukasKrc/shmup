package lt.Shmup.Main.Input.Commands.Keyboard.Firing;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameObject.Objects.Entity;

public class FirePressed implements Command {
    private Entity entity;
    private boolean isKeyPressed;

    public FirePressed(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void execute() {
        if (this.isKeyPressed) {
            return;
        }
        entity.notifyObservers("projectile_fired", null);
        this.setKeyPressed(true);
    }

    public void setKeyPressed(boolean isPressed) {
        this.isKeyPressed = isPressed;
    }
}
