package lt.Shmup.Main.GameObject.Components.State.Positions;

import lt.Shmup.Main.GameObject.Components.State.Position;

public class BasicPosition implements Position {
    private float x, y;

    public BasicPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public Position clone() {
        return new BasicPosition(x, y);
    }
}
