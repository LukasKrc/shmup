package lt.Shmup.Main.GameObject;

import java.awt.*;

public abstract class Renderable {
    private int layerIndex;

    public Renderable(int layerIndex) {
        this.layerIndex = layerIndex;
    }

    public int getLayerIndex() {
        return layerIndex;
    }

    public abstract void render(Graphics2D graphics);
}
