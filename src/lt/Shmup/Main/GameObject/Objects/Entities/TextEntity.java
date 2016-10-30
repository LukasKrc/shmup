package lt.Shmup.Main.GameObject.Objects.Entities;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Visitor;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class TextEntity extends Entity {
    private String text;
    private Color color;
    private Font font;

    public TextEntity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            EntityAwareUpdateable behaviour,
            EntityAwareRenderable renderable,
            HashMap<String, String> data,
            boolean isCollidable,
            LinkedList<EntityObserver> observers,
            String text,
            Font font,
            Color color
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
                data,
                isCollidable,
                observers
        );
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void acceptRenderVisitor(Visitor visitor, Graphics2D graphics) {
        visitor.visitRendering(graphics, this);
    }
}
