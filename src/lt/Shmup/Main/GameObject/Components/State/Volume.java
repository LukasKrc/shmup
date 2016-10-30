package lt.Shmup.Main.GameObject.Components.State;

import java.awt.*;

public interface Volume {
    float getWidth();
    float getHeight();
    Rectangle getBounds();
    Volume clone();
}
