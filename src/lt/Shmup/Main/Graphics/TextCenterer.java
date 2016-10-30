package lt.Shmup.Main.Graphics;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volume;

import java.awt.*;

/**
 * Created by lukas on 16.10.28.
 */
public interface TextCenterer {
    BasicPosition createCenteredTextPosition(
            Graphics graphics,
            Position position,
            Volume volume,
            String text
    );
}
