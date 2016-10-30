package lt.Shmup.Main.Input.Commands.Keyboard.Movement;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameObject.Objects.Entity;

public abstract class MovementCommand implements Command {
    private Entity entity;
    private int speed;

    public MovementCommand(Entity entity, int speed) {
        this.entity = entity;
        this.speed = speed;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getSpeed() {
        return speed;
    }
}
