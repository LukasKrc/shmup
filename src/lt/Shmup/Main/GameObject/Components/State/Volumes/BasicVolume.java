package lt.Shmup.Main.GameObject.Components.State.Volumes;

import lt.Shmup.Main.GameObject.Components.State.Volume;
import java.awt.*;

public class BasicVolume implements Volume {
    private float width, height;

    public BasicVolume(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) width, (int) height);
    }

    @Override
    public Volume clone() {
        return new BasicVolume(width, height);
    }
}
