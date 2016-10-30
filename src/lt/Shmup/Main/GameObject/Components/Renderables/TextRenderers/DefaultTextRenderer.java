package lt.Shmup.Main.GameObject.Components.Renderables.TextRenderers;

import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderer;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.Graphics.TextCenterer;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;

import java.awt.*;

public class DefaultTextRenderer implements TextRenderer {
    private TextCenterer textCenterer;

    public DefaultTextRenderer(
            TextCenterer textCenterer
    ) {
        this.textCenterer = textCenterer;
    }

    @Override
    public void render(Graphics2D graphics, TextEntity entity) {
        graphics.setFont(entity.getFont());
        String text = entity.getText();
        BasicPosition position = getCenteredPosition(graphics, entity, text);
        graphics.setColor(getFontColor(entity));
        graphics.drawString(
                text,
                position.getX(),
                position.getY()
        );
    }

    private BasicPosition getCenteredPosition(
            Graphics graphics,
            Entity entity,
            String text
    ) {
        return textCenterer.createCenteredTextPosition(
                graphics,
                entity.getPosition(),
                entity.getVolume(),
                text
        );
    }

    private Color getFontColor(TextEntity entity) {
        return entity.getColor();
    }
}