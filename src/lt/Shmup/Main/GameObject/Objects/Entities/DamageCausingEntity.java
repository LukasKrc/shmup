package lt.Shmup.Main.GameObject.Objects.Entities;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
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
            EntityAwareUpdateable behaviour,
            EntityAwareRenderable renderable,
            HashMap<String, String> data,
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
                data,
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
            EntityAwareUpdateable behaviour,
            EntityAwareRenderable renderable,
            HashMap<String, String> data,
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
                data,
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
                new HashMap<>(),
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
