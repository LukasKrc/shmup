package test.lt.Shmup.Main.GameObject.Components.Updateables.Behaviour; 

import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Builders.EntityBuilders.DefaultEntityBuilder;
import lt.Shmup.Main.GameObject.Builders.NullCreators.DefaultNullCreator;
import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.BasicBehaviour;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.LinearMovement;
import lt.Shmup.Main.GameObject.Objects.Entity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.Mock;

import java.util.Random;

import static org.mockito.Mockito.*;

/** 
* BasicBehaviour Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class BasicBehaviourTest {
    private EntityBuilder entityBuilder;

    public BasicBehaviourTest() {
        entityBuilder = new DefaultEntityBuilder(new DefaultNullCreator());
    }

    @Test
    public void randomlyChangesDirectionAndFiresProjectileWhenNeeded() {
        float xSpeed = 10;
        Random randomGenerator = mock(Random.class);
        when(randomGenerator.nextBoolean()).thenReturn(true);
        BasicBehaviour behaviour = new BasicBehaviour(randomGenerator);
        Entity entity = mock(Entity.class);
        Movement movement = mock(Movement.class);
        when(movement.getSpeedX()).thenReturn(xSpeed);
        when(entity.getMovement()).thenReturn(movement);
        behaviour.update(entity);
        verify(entity).notifyObservers("projectile_fired", null);
        verify(movement).setSpeedX(-xSpeed);
    }

    @Test
    public void doesNothingWhenNeeded() {
        float xSpeed = 10;
        Random randomGenerator = mock(Random.class);
        when(randomGenerator.nextBoolean()).thenReturn(false);
        BasicBehaviour behaviour = new BasicBehaviour(randomGenerator);
        Entity entity = mock(Entity.class);
        Movement movement = mock(Movement.class);
        when(movement.getSpeedX()).thenReturn(xSpeed);
        when(entity.getMovement()).thenReturn(movement);
        behaviour.update(entity);
        verify(entity, never()).notifyObservers("projectile_fired", null);
        verify(movement, never()).setSpeedX(-xSpeed);
    }
}
