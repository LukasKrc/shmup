package lt.Shmup.Main.GameObject.ObjectHandlers;

import lt.Shmup.Main.GameObject.*;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;
import java.util.LinkedList;

public class DefaultObjectHandler implements ObjectHandler {
    private CollisionFinder collisionFinder;
    private Visitor visitor;

    private LinkedList<Entity> entityObjects = new LinkedList<>();
    private LinkedList<Entity> entityObjectAddBuffer = new LinkedList<>();
    private LinkedList<Entity> entityObjectRemoveBuffer = new LinkedList<>();

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
        handleEntityAdditionAndRemoval();
    }

    private void handleEntityAdditionAndRemoval() {
        entityObjects.addAll(this.entityObjectAddBuffer);
        entityObjects.removeAll(this.entityObjectRemoveBuffer);
        entityObjectAddBuffer.clear();
        entityObjectRemoveBuffer.clear();
    }

    @Override
    public void render(Graphics2D graphics) {
        entityObjects.sort((o1, o2) -> o1.getLayerIndex() - o2.getLayerIndex());
        for (Entity entity : entityObjects) {
            entity.acceptRenderVisitor(visitor, graphics);
        }
    }

    @Override
    public void addEntity(lt.Shmup.Main.GameObject.Objects.Entity entity) {
        entityObjectAddBuffer.add(entity);
        collisionFinder.addEntity(entity);
        entity.setObjectHandler(this);
    }

    @Override
    public void removeEntity(lt.Shmup.Main.GameObject.Objects.Entity entity) {
        collisionFinder.removeEntity(entity);
        entityObjectRemoveBuffer.add(entity);
    }
}
