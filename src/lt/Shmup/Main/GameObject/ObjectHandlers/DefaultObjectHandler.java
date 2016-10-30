package lt.Shmup.Main.GameObject.ObjectHandlers;

import lt.Shmup.Main.GameObject.*;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;

public class DefaultObjectHandler implements ObjectHandler {
    private CollisionFinder collisionFinder;
    private Visitor visitor;

    private LinkedList<Entity> entityObjects = new LinkedList<>();
    private LinkedList<Entity> entityObjectAddBuffer = new LinkedList<>();
    private LinkedList<Entity> entityObjectRemoveBuffer = new LinkedList<>();

    private LinkedList<Entity> renderableObjects = new LinkedList<>();
    private LinkedList<Entity> renderableObjectAddBuffer = new LinkedList<>();
    private LinkedList<Entity> renderableObjectRemoveBuffer = new LinkedList<>();

    public DefaultObjectHandler(
            CollisionFinder collisionFinder,
            Visitor visitor
    ) {
        this.collisionFinder = collisionFinder;
        this.visitor = visitor;
    }

    @Override
    public CollisionFinder getCollisionFinder() {
        return collisionFinder;
    }

    @Override
    public void update() {
        for (Entity entity : entityObjects) {
            entity.acceptUpdateVisitor(visitor);
        }
        handleUpdateableObjectAdditionAndRemoval();
        handleRenderableObjectAdditionAndRemoval();
    }

    private void handleUpdateableObjectAdditionAndRemoval() {
        entityObjects.addAll(this.entityObjectAddBuffer);
        entityObjects.removeAll(this.entityObjectRemoveBuffer);
        entityObjectAddBuffer.clear();
        entityObjectRemoveBuffer.clear();
    }

    private void handleRenderableObjectAdditionAndRemoval() {
        renderableObjects.addAll(this.renderableObjectAddBuffer);
        renderableObjects.removeAll(this.renderableObjectRemoveBuffer);
        renderableObjectAddBuffer.clear();
        renderableObjectRemoveBuffer.clear();
    }

    @Override
    public void render(Graphics2D graphics) {
        renderableObjects.sort((o1, o2) -> o1.getLayerIndex() - o2.getLayerIndex());
        for (Entity entity : this.renderableObjects) {
            entity.acceptRenderVisitor(visitor, graphics);
        }
    }

    @Override
    public void addEntity(lt.Shmup.Main.GameObject.Objects.Entity entity) {
        renderableObjectAddBuffer.add(entity);
        entityObjectAddBuffer.add(entity);
        collisionFinder.addEntity(entity);
        entity.setObjectHandler(this);
    }

    @Override
    public void removeEntity(lt.Shmup.Main.GameObject.Objects.Entity entity) {
        collisionFinder.removeEntity(entity);
        renderableObjectRemoveBuffer.add(entity);
        entityObjectRemoveBuffer.add(entity);
    }

    @Override
    public void addEntities(Collection entities) {
        renderableObjectAddBuffer.addAll(entities);
        entityObjectAddBuffer.addAll(entities);
    }
}
