package lt.shmup.main.game.gameobject;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    private LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void update(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            gameObject.update(graphics);
        }
    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }

    public LinkedList<GameObject> getGameObjects() {
        return this.gameObjects;
    }
}
