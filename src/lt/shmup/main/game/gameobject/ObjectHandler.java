package lt.shmup.main.game.gameobject;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    private LinkedList<GameObject> gameObjects = new LinkedList<>();
    private LinkedList<GameObject> objectAddBuffer = new LinkedList<>();
    private LinkedList<GameObject> objectRemoveBuffer = new LinkedList<>();

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
        this.gameObjects.addAll(this.objectAddBuffer);
        this.gameObjects.removeAll(this.objectRemoveBuffer);
        this.objectAddBuffer.clear();
    }

    public void render(Graphics2D graphics) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(graphics);
        }
    }

    public void addObject(GameObject object) {
        this.objectAddBuffer.add(object);
    }

    public void removeObject(GameObject object) {
        this.objectRemoveBuffer.add(object);
    }

    public LinkedList<GameObject> getGameObjects() {
        return this.gameObjects;
    }
}
