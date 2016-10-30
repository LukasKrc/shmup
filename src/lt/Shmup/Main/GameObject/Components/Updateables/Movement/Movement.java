package lt.Shmup.Main.GameObject.Components.Updateables.Movement;

import lt.Shmup.Main.GameObject.EntityAwareUpdateable;

public abstract class Movement implements EntityAwareUpdateable {
    private float speedX;
    private float speedY;

    public Movement(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public abstract Movement clone();
}
