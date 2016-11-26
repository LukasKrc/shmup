package test.lt.Shmup.Main.GameObject.Builders.EntityBuilders; 

import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Builders.EntityBuilders.DefaultEntityBuilder;
import lt.Shmup.Main.GameObject.Builders.NullCreator;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

/** 
* DefaultEntityBuilder Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class DefaultEntityBuilderTest {
    private int layerIndex = 0;
    private Identifier identifier;
    private Position position;
    private Volume volume;
    private Health health;
    private Movement movement;
    private Updateable behaviour;
    private Renderable renderable;
    private boolean isCollidable;
    private int collisionDamage;
    private String text;
    private HashMap<ButtonState, Color> buttonStateColors;
    private Font font;
    private Color color;

    @Before
    public void before() {
        setFieldsToBePassed();
    }

    private void setFieldsToBePassed() {
        layerIndex = 0;
        identifier = Identifier.Player;
        position = mock(Position.class);
        volume = mock(Volume.class);
        health = mock(Health.class);
        movement = mock(Movement.class);
        behaviour = mock(Updateable.class);
        renderable = mock(Renderable.class);
        isCollidable = false;
        collisionDamage = 0;
        text = "foo";
        buttonStateColors = new HashMap<>();
        font = new Font("arial", 0, 0);
        color = new Color(0, 0, 0);
    }

    @Test
    public void createsEntityWithGivenComponents() {
        NullCreator nullCreator = mock(NullCreator.class);
        DefaultEntityBuilder entityBuilder =
                new DefaultEntityBuilder(nullCreator);
        setEntityBuilderFields(entityBuilder);
        Entity entity = entityBuilder.getEntity();
        assertEntityFieldsAreIdentical(entity);
    }

    @Test
    public void createsDamageCausingEntityWithGivenComponents() {
        NullCreator nullCreator = mock(NullCreator.class);
        DefaultEntityBuilder entityBuilder =
                new DefaultEntityBuilder(nullCreator);
        setEntityBuilderFields(entityBuilder);
        DamageCausingEntity entity = entityBuilder.getDamageCausingEntity();
        assertEntityFieldsAreIdentical(entity);
        assertEquals(collisionDamage, entity.getCollisionDamage());
    }

    @Test
    public void createsButtonEntityWithGivenComponents() {
        NullCreator nullCreator = mock(NullCreator.class);
        DefaultEntityBuilder entityBuilder =
                new DefaultEntityBuilder(nullCreator);
        setEntityBuilderFields(entityBuilder);
        ButtonEntity entity = entityBuilder.getButtonEntity();
        assertEntityFieldsAreIdentical(entity);
        assertSame(text, entity.getText());
        assertEquals(new LinkedList<EntityObserver>(), entity.getObservers());
        assertSame(font, entity.getFont());
        assertSame(color, entity.getColor());
        assertSame(buttonStateColors, entity.getButtonStateColors());
    }

    @Test
    public void createsTextEntityWithGivenComponents() {
        NullCreator nullCreator = mock(NullCreator.class);
        DefaultEntityBuilder entityBuilder =
                new DefaultEntityBuilder(nullCreator);
        setEntityBuilderFields(entityBuilder);
        TextEntity entity = entityBuilder.getTextEntity();
        assertEntityFieldsAreIdentical(entity);
        assertSame(text, entity.getText());
        assertEquals(new LinkedList<EntityObserver>(), entity.getObservers());
        assertSame(font, entity.getFont());
        assertSame(color, entity.getColor());
    }

    @Test
    public void fieldsGetResetAndNullCreatorGetsCalled() {
        NullCreator nullCreator = mock(NullCreator.class);
        Health nullHealth = mock(Health.class);
        Movement nullMovement = mock(Movement.class);
        Renderable nullRenderable = mock(Renderable.class);
        Updateable nullUpdateable = mock(Updateable.class);
        when(nullCreator.getHealth()).thenReturn(nullHealth);
        when(nullCreator.getMovement()).thenReturn(nullMovement);
        when(nullCreator.getRenderable()).thenReturn(nullRenderable);
        when(nullCreator.getUpdateable()).thenReturn(nullUpdateable);
        DefaultEntityBuilder entityBuilder =
                new DefaultEntityBuilder(nullCreator);
        setEntityBuilderFields(entityBuilder);
        entityBuilder.reset(EntityBuilder.RESET_ALL);
        Entity entity = entityBuilder.getEntity();
        verify(nullCreator).getHealth();
        verify(nullCreator).getMovement();
        verify(nullCreator).getRenderable();
        verify(nullCreator).getUpdateable();
        assertSame(nullHealth, entity.getHealth());
        assertSame(nullMovement, entity.getMovement());
        assertSame(nullRenderable, entity.getRenderable());
        assertSame(nullUpdateable, entity.getBehaviour());
    }

    private void assertEntityFieldsAreIdentical(Entity entity) {
        assertEquals(layerIndex, entity.getLayerIndex());
        assertEquals(identifier, entity.getIdentifier());
        assertSame(position, entity.getPosition());
        assertSame(volume, entity.getVolume());
        assertSame(health, entity.getHealth());
        assertSame(movement, entity.getMovement());
        assertSame(behaviour, entity.getBehaviour());
        assertSame(renderable, entity.getRenderable());
        assertEquals(isCollidable, entity.isCollidable());
    }

    private void setEntityBuilderFields(EntityBuilder entityBuilder) {
        entityBuilder.setLayerIndex(layerIndex);
        entityBuilder.setIdentifier(identifier);
        entityBuilder.setPosition(position);
        entityBuilder.setVolume(volume);
        entityBuilder.setHealth(health);
        entityBuilder.setMovement(movement);
        entityBuilder.setBehaviour(behaviour);
        entityBuilder.setRenderable(renderable);
        entityBuilder.setIsCollidable(isCollidable);
        entityBuilder.setCollisionDamage(collisionDamage);
        entityBuilder.setText(text);
        entityBuilder.setButtonStateColors(buttonStateColors);
        entityBuilder.setFont(font);
        entityBuilder.setColor(color);
    }

} 
