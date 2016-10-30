package lt.Shmup.Main.GameObject.Components.State;

public interface Position {
    float getX();
    float getY();
    void setX(float x);
    void setY(float y);
    Position clone();
}
