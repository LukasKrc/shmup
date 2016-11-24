package lt.Shmup.Main.GameObject.Objects.Entities;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Visitor;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ButtonEntity extends TextEntity {
    private ButtonState state;
    private HashMap<ButtonState, Color> buttonStateColors;

    public ButtonEntity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            Updateable behaviour,
            Renderable renderable,
            boolean isCollidable,
            LinkedList<EntityObserver> observers,
            String text,
            Font font,
            Color color,
            HashMap<ButtonState, Color> buttonStateColors
    ) {
        super(
                layerIndex,
                identifier,
                position,
                volume,
                health,
                movement,
                behaviour,
                renderable,
                isCollidable,
                observers,
                text,
                font,
                color
        );
        this.buttonStateColors = buttonStateColors;
    }

    public ButtonState getState() {
        return state;
    }

    public void setState(ButtonState state) {
        this.state = state;
    }

    public HashMap<ButtonState, Color> getButtonStateColors() {
        return buttonStateColors;
    }

    @Override
    public void acceptRenderVisitor(Visitor visitor, Graphics2D graphics) {
        visitor.visitRendering(graphics, this);
    }
}
