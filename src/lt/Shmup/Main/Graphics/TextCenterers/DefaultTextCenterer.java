package lt.Shmup.Main.Graphics.TextCenterers;

import lt.Shmup.Main.Graphics.TextCenterer;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volume;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DefaultTextCenterer implements TextCenterer {
    @Override
    public BasicPosition createCenteredTextPosition(
            Graphics graphics,
            Position position,
            Volume volume,
            String text
    ) {
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D textBounds = fontMetrics.getStringBounds(text, graphics);
        return getCenteredPosition(position, volume, fontMetrics, textBounds);
    }

    private BasicPosition getCenteredPosition(
            Position position,
            Volume volume,
            FontMetrics fontMetrics,
            Rectangle2D textBounds
    ) {
        float containerWidth = volume.getWidth();
        float containerHeight = volume.getHeight();
        float containerX = position.getX();
        float containerY = position.getY();
        float centeredX =
                (float) ((containerWidth - textBounds.getWidth()) / 2);
        float centeredY =
                (float) ((((containerHeight - textBounds.getHeight()) / 2))
                        + fontMetrics.getAscent()
                );

        return new BasicPosition(containerX + centeredX, containerY + centeredY);
    }
}