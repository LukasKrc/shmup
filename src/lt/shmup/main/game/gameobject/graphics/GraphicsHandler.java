package lt.shmup.main.game.gameobject.graphics;

import lt.shmup.main.game.gameobject.GameObject;

import java.awt.*;

public interface GraphicsHandler {

    void render(Graphics graphics, GameObject gameObject);

}