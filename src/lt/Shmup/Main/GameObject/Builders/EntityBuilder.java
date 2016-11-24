package lt.Shmup.Main.GameObject.Builders;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;

import java.awt.*;
import java.util.HashMap;

public interface EntityBuilder {
    int RESET_NONE = 0;
    int RESET_UPDATEABLES = 1;
    int RESET_DATA = 2;
    int RESET_UPDATEABLES_DATA = 3;
    int RESET_RENDERABLES = 4;
    int RESET_UPDATEABLES_RENDERABLES = 5;
    int RESET_DATA_RENDERABLES = 6;
    int RESET_ALL = 7;

    EntityBuilder setLayerIndex(int layerIndex);
    EntityBuilder setIdentifier(Identifier identifier);
    EntityBuilder setPosition(Position position);
    EntityBuilder setVolume(Volume volume);
    EntityBuilder setHealth(Health health);
    EntityBuilder setColor(Color color);
    EntityBuilder setMovement(Movement movement);
    EntityBuilder setBehaviour(Updateable behaviour);
    EntityBuilder setRenderable(Renderable renderable);
    EntityBuilder setIsCollidable(boolean isCollidable);
    EntityBuilder setCollisionDamage(int collisionDamage);
    Entity getEntity();
    ButtonEntity getButtonEntity(int resetLevel);
    EntityBuilder setText(String text);
    EntityBuilder setButtonStateColors(HashMap<ButtonState, Color> colors);
    EntityBuilder setFont(Font font);
    TextEntity getTextEntity(int resetLevel);
    Entity getEntity(int resetLevel);
    EntityBuilder reset(int resetLevel);
    DamageCausingEntity getDamageCausingEntity(int resetLevel);
}
