package lt.Shmup.Main.GameObject.Objects;

import lt.Shmup.Main.GameObject.*;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Entity implements Visitable {
    private int layerIndex;
    private Identifier identifier;
    private Position position;
    private Volume volume;
    private Health health;
    private Movement movement;
    private EntityAwareUpdateable behaviour;
    private EntityAwareRenderable renderable;
    private ObjectHandler objectHandler;
    private LinkedList<EntityObserver> observers = new LinkedList<>();
    private HashMap<String, String> data;
    private boolean isCollidable;

    public Entity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            EntityAwareUpdateable behaviour,
            EntityAwareRenderable renderable,
            HashMap<String, String> data,
            boolean isCollidable,
            LinkedList<EntityObserver> observers
    ) {
        this.layerIndex = layerIndex;
        this.identifier = identifier;
        this.position = position;
        this.volume = volume;
        this.health = health;
        this.movement = movement;
        this.behaviour = behaviour;
        this.renderable = renderable;
        this.data = data;
        this.isCollidable = isCollidable;
        this.observers = observers;
    }

    public Entity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            EntityAwareUpdateable behaviour,
            EntityAwareRenderable renderable,
            HashMap<String, String> data,
            boolean isCollidable
    ) {
        this.layerIndex = layerIndex;
        this.identifier = identifier;
        this.position = position;
        this.volume = volume;
        this.health = health;
        this.movement = movement;
        this.behaviour = behaviour;
        this.renderable = renderable;
        this.data = data;
        this.isCollidable = isCollidable;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getLayerIndex() {
        return layerIndex;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public EntityAwareUpdateable getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(EntityAwareUpdateable behaviour) {
        this.behaviour = behaviour;
    }

    public EntityAwareRenderable getRenderable() {
        return renderable;
    }

    public void setRenderable(EntityAwareRenderable renderable) {
        this.renderable = renderable;
    }

    public LinkedList<EntityObserver> getObservers() {
        return observers;
    }

    public ObjectHandler getObjectHandler() {
        return objectHandler;
    }

    public void setObjectHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    public String getData(String key) {
        return data.getOrDefault(key, "");
    }

    public void setData(String key, String dataValue) {
        data.put(key, dataValue);
    }

    public void attachObserver(EntityObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String event, HashMap<String, String> data) {
        for (EntityObserver observer : observers) {
            observer.notify(this, event, data);
        }
    }

    public Entity clone() {
        Entity clone = new Entity(
                getLayerIndex(),
                identifier,
                position.clone(),
                volume.clone(),
                health.clone(),
                movement.clone(),
                behaviour.clone(),
                renderable.clone(),
                data,
                isCollidable
        );
        for (EntityObserver observer : observers) {
            clone.attachObserver(observer.clone());
        }
        return clone;
    }

    public Rectangle getBounds() {
        return new Rectangle(
                (int) position.getX(),
                (int) position.getY(),
                (int) volume.getWidth(),
                (int) volume.getHeight()
        );
    }

    public boolean isCollidable() {
        return isCollidable;
    }

    @Override
    public void acceptUpdateVisitor(Visitor visitor) {
        visitor.visitUpdating(this);
    }

    @Override
    public void acceptRenderVisitor(Visitor visitor, Graphics2D graphics) {
        visitor.visitRendering(graphics, this);
    }
}