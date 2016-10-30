package lt.Shmup.Main.GameObject.Builders.EntityBuilders;

import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Builders.NullCreator;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class DefaultEntityBuilder implements EntityBuilder {
    private NullCreator nullCreator;
    private int layerIndex = 0;
    private Identifier identifier;
    private Position position;
    private Volume volume;
    private Health health;
    private Movement movement;
    private EntityAwareUpdateable behaviour;
    private EntityAwareRenderable renderable;
    private HashMap<String, String> data;
    private boolean isCollidable;
    private int collisionDamage;
    private String text;
    private HashMap<ButtonState, Color> buttonStateColors;
    private Font font;
    private Color color;

    public DefaultEntityBuilder(NullCreator nullCreator) {
        this.nullCreator = nullCreator;
    }

    @Override
    public EntityBuilder setLayerIndex(int layerIndex) {
        this.layerIndex = layerIndex;
        return this;
    }

    @Override
    public EntityBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    @Override
    public EntityBuilder setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public EntityBuilder setVolume(Volume volume) {
        this.volume = volume;
        return this;
    }

    @Override
    public EntityBuilder setHealth(Health health) {
        this.health = health;
        return this;
    }

    @Override
    public EntityBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public EntityBuilder setMovement(Movement movement) {
        this.movement = movement;
        return this;
    }

    @Override
    public EntityBuilder setBehaviour(EntityAwareUpdateable behaviour) {
        this.behaviour = behaviour;
        return this;
    }

    @Override
    public EntityBuilder setRenderable(EntityAwareRenderable renderable) {
        this.renderable = renderable;
        return this;
    }

    @Override
    public EntityBuilder putData(String key, String dataValue) {
        initializeData();
        data.put(key, dataValue);
        return this;
    }

    @Override
    public EntityBuilder setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
        return this;
    }

    @Override
    public EntityBuilder setCollisionDamage(int collisionDamage) {
        this.collisionDamage = collisionDamage;
        return this;
    }

    @Override
    public Entity getEntity() {
        return getEntity(RESET_NONE);
    }

    @Override
    public DamageCausingEntity getDamageCausingEntity() {
        return getDamageCausingEntity(RESET_NONE);
    }

    @Override
    public DamageCausingEntity getDamageCausingEntity(int resetLevel) {
        setNullFields();
        DamageCausingEntity entity = createDamageCausingEntity();
        resetFields(resetLevel);
        return entity;
    }

    private DamageCausingEntity createDamageCausingEntity() {
        return new DamageCausingEntity(
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
                collisionDamage
        );
    }

    @Override
    public ButtonEntity getButtonEntity() {
        return getButtonEntity(RESET_ALL);
    }

    @Override
    public ButtonEntity getButtonEntity(int resetLevel) {
        setNullFields();
        ButtonEntity entity = createButtonEntity();
        resetFields(resetLevel);
        return entity;
    }

    private ButtonEntity createButtonEntity() {
        return new ButtonEntity(
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
                new LinkedList<EntityObserver>(),
                text,
                font,
                color,
                buttonStateColors
        );
    }

    @Override
    public EntityBuilder setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public EntityBuilder setButtonStateColors(HashMap<ButtonState, Color> colors) {
        this.buttonStateColors = colors;
        return this;
    }

    @Override
    public EntityBuilder setFont(Font font) {
        this.font = font;
        return this;
    }

    @Override
    public TextEntity getTextEntity() {
        setNullFields();
        TextEntity entity = createTextEntity();
        resetFields(RESET_ALL);
        return entity;
    }

    @Override
    public TextEntity getTextEntity(int resetLevel) {
        setNullFields();
        TextEntity entity = createTextEntity();
        resetFields(resetLevel);
        return entity;
    }

    private TextEntity createTextEntity() {
        return new TextEntity(
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
                new LinkedList<EntityObserver>(),
                text,
                font,
                color
        );
    }

    @Override
    public Entity getEntity(int resetLevel) {
        setNullFields();
        Entity entity = createEntity();
        resetFields(resetLevel);
        return entity;
    }

    private void initializeData() {
        if (data == null) {
            data = new HashMap<String, String>();
        }
    }

    private Entity createEntity() {
        return new Entity(
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
    }

    private void setNullFields() {
        setNullStates();
        setNullUpdateables();
        setNullRenderable();
    }

    private void setNullStates() {
        if (identifier == null) {
            identifier = Identifier.Unidentified;
        }
        if (position == null) {
            position = new BasicPosition(0, 0);
        }
        if (volume == null) {
            volume = new BasicVolume(0, 0);
        }
        isCollidable = true;
        initializeData();
    }

    private void setNullUpdateables() {
        if (health == null) {
            health = nullCreator.getHealth();
        }
        if (movement == null) {
            movement = nullCreator.getMovement();
        }
        EntityAwareUpdateable nullUpdateable = nullCreator.getUpdateable();
        if (behaviour == null) {
            behaviour = nullUpdateable;
        }
    }

    private void setNullRenderable() {
        if (renderable == null) {
            renderable = nullCreator.getRenderable();
        }
    }

    private void resetFields(int resetLevel) {
        if ((resetLevel & RESET_DATA) == RESET_DATA) {
            data = null;
            identifier = null;
        }
        if ((resetLevel & RESET_UPDATEABLES) == RESET_UPDATEABLES) {
            position = null;
            volume = null;
            health = null;
            movement = null;
            behaviour = null;
        }
        if ((resetLevel & RESET_RENDERABLES) == RESET_RENDERABLES) {
            renderable = null;
        }
    }

    @Override
    public EntityBuilder reset(int resetLevel) {
        resetFields(resetLevel);
        return this;
    }
}
