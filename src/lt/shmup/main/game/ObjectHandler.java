package lt.shmup.main.game;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    private LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    public void render(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }
}
