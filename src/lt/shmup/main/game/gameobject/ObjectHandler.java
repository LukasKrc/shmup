package lt.shmup.main.game.gameobject;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

    private LinkedList<Updateable> updateableObjects = new LinkedList<>();
    private LinkedList<Updateable> updateableObjectAddBuffer = new LinkedList<>();
    private LinkedList<Updateable> updateableObjectRemoveBuffer = new LinkedList<>();

    private LinkedList<Renderable> renderableObjects = new LinkedList<>();
    private LinkedList<Renderable> renderableObjectAddBuffer = new LinkedList<>();
    private LinkedList<Renderable> renderableObjectRemoveBuffer = new LinkedList<>();

    public void update() {
        for (Updateable updateableObject : updateableObjects) {
            updateableObject.update();
        }
        this.handleUpdateableObjectAdditionAndRemoval();
        this.handleRenderableObjectAdditionAndRemoval();
    }

    private void handleUpdateableObjectAdditionAndRemoval() {
        this.updateableObjects.addAll(this.updateableObjectAddBuffer);
        this.updateableObjects.removeAll(this.updateableObjectRemoveBuffer);
        this.updateableObjectAddBuffer.clear();
        this.updateableObjectRemoveBuffer.clear();
    }

    private void handleRenderableObjectAdditionAndRemoval() {
        this.renderableObjects.addAll(this.renderableObjectAddBuffer);
        this.renderableObjects.removeAll(this.renderableObjectRemoveBuffer);
        this.renderableObjectAddBuffer.clear();
        this.renderableObjectRemoveBuffer.clear();
    }

    public void render(Graphics2D graphics) {
        for (Renderable renderableObject : renderableObjects) {
            renderableObject.render(graphics);
        }
    }

    public void addUpdateableObject(Updateable object) {
        this.updateableObjectAddBuffer.add(object);
    }

    public void removeUpdateableObject(Updateable object) {
        this.updateableObjectRemoveBuffer.add(object);
    }

    public LinkedList<Updateable> getUpdateableObjects() {
        return this.updateableObjects;
    }

    public void addRenderableObject(Renderable object) {
        this.renderableObjectAddBuffer.add(object);
    }

    public void removeRenderableObject(Renderable object) {
        this.renderableObjectRemoveBuffer.add(object);
    }

    public LinkedList<Renderable> getRenderableObjects() {
        return this.renderableObjects;
    }
}
