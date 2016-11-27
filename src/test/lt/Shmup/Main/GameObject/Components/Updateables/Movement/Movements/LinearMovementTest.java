package test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements; 

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.LinearMovement;
import lt.Shmup.Main.GameObject.Objects.Entity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** 
* LinearMovement Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class LinearMovementTest { 
    @Test
    public void updatesPosition() {
        int speedX = 10;
        int speedY = 10;
        Entity entity = mock(Entity.class);
        Position position = mock(Position.class);
        when(entity.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn((float) 0);
        when(position.getY()).thenReturn((float) 0);
        LinearMovement movement = new LinearMovement(speedX, speedY);
        movement.update(entity);
        verify(position).setX(speedX);
        verify(position).setY(speedY);
    }
} 
