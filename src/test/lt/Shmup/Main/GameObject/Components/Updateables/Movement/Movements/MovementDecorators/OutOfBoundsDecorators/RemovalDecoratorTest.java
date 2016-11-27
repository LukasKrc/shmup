package test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators; 

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsCheckers.DefaultOutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.ReflectDecorator;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.RemovalDecorator;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Utility;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/** 
* RemovalDecorator Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class RemovalDecoratorTest {
    @Test
    public void removesEntityWhenOutOfBounds() {
        float movementX = 10;
        float movementY = 10;
        Movement movement = mock(Movement.class);
        when(movement.getSpeedX()).thenReturn(movementX);
        when(movement.getSpeedY()).thenReturn(movementY);
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        RemovalDecorator removalDecorator = new RemovalDecorator(movement, new DefaultOutOfBoundsChecker(), objectHandler);
        int entityWidth = 20;
        int entityHeight = 20;
        Position position = new BasicPosition(
                Utility.WINDOW_WIDTH,
                Utility.WINDOW_HEIGHT
        );
        Volume volume = new BasicVolume(entityWidth, entityHeight);
        Entity entity = mock(Entity.class);
        when(entity.getPosition()).thenReturn(position);
        when(entity.getVolume()).thenReturn(volume);
        when(entity.getMovement()).thenReturn(movement);
        removalDecorator.update(entity);
        verify(objectHandler).removeEntity(entity);
    }

    @Test
    public void doesntRemoveEntityWhenTouchingBounds() {
        float movementX = 10;
        float movementY = 10;
        Movement movement = mock(Movement.class);
        when(movement.getSpeedX()).thenReturn(movementX);
        when(movement.getSpeedY()).thenReturn(movementY);
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        RemovalDecorator removalDecorator = new RemovalDecorator(movement, new DefaultOutOfBoundsChecker(), objectHandler);
        int entityWidth = 20;
        int entityHeight = 20;
        Position position = new BasicPosition(
                Utility.WINDOW_WIDTH - entityWidth,
                Utility.WINDOW_HEIGHT - entityHeight
        );
        Volume volume = new BasicVolume(entityWidth, entityHeight);
        Entity entity = mock(Entity.class);
        when(entity.getPosition()).thenReturn(position);
        when(entity.getVolume()).thenReturn(volume);
        when(entity.getMovement()).thenReturn(movement);
        removalDecorator.update(entity);
        verify(objectHandler, never()).removeEntity(entity);
    }
} 
