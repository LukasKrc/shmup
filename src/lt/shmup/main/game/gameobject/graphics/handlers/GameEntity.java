package lt.shmup.main.game.gameobject.graphics.handlers;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;

import java.awt.*;

public class GameEntity implements GraphicsHandler {

    private int width, height;
    private Color color;

    public GameEntity(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, GameObject gameObject) {
        graphics.setColor(this.color);
        graphics.fillRect(
                gameObject.getX(),
                gameObject.getY(),
                this.width,
                this.height
        );
    }

}
