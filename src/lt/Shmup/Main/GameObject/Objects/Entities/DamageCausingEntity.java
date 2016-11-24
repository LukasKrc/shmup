package lt.Shmup.Main.GameObject.Objects.Entities;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Visitor;

import java.util.HashMap;
import java.util.LinkedList;

public class DamageCausingEntity extends Entity {
    private int collisionDamage;

    public DamageCausingEntity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            Updateable behaviour,
            Renderable renderable,
            boolean isCollidable,
            int collisionDamage,
            LinkedList<EntityObserver> observers
    ) {
        super(
                layerIndex,
                identifier,
                position,
                volume,
                health,
                movement,
                behaviour,
                renderable,
                isCollidable,
                observers
        );
        this.collisionDamage = collisionDamage;
    }

    public DamageCausingEntity(
            int layerIndex,
            Identifier identifier,
            Position position,
            Volume volume,
            Health health,
            Movement movement,
            Updateable behaviour,
            Renderable renderable,
            boolean isCollidable,
            int collisionDamage
    ) {
        super(
                layerIndex,
                identifier,
                position,
                volume,
                health,
                movement,
                behaviour,
                renderable,
                isCollidable
        );
        this.collisionDamage = collisionDamage;
    }

    public int getCollisionDamage() {
        return collisionDamage;
    }

    public void setCollisionDamage(int collisionDamage) {
        this.collisionDamage = collisionDamage;
    }

    @Override
    public DamageCausingEntity clone() {
        return new DamageCausingEntity(
                getLayerIndex(),
                getIdentifier(),
                getPosition().clone(),
                getVolume().clone(),
                getHealth().clone(),
                getMovement().clone(),
                getBehaviour().clone(),
                getRenderable().clone(),
                isCollidable(),
                collisionDamage,
                getObservers()
        );
    }

    @Override
    public void acceptUpdateVisitor(Visitor visitor) {
        visitor.visitUpdating(this);
    }
}
