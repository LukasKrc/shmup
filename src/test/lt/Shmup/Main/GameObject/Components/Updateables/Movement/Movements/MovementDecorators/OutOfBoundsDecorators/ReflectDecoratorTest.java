package test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators; 

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsCheckers.DefaultOutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.ReflectDecorator;
import lt.Shmup.Main.GameObject.Objects.Entity;

import lt.Shmup.Utility;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/** 
* ReflectDecorator Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/
public class ReflectDecoratorTest {
    @Test
    public void reflectsBeforeGoinOutOfBounds() {
        float movementX = 10;
        float movementY = 10;
        Movement movement = mock(Movement.class);
        when(movement.getSpeedX()).thenReturn(movementX);
        when(movement.getSpeedY()).thenReturn(movementY);
        ReflectDecorator reflectDecorator = new ReflectDecorator(movement, new DefaultOutOfBoundsChecker());
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
        reflectDecorator.update(entity);
        verify(movement).setSpeedX(-movementX);
        verify(movement).setSpeedY(-movementY);
    }
} 
