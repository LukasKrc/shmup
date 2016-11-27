package test.lt.Shmup.Main.GameObject.Components.Updateables.Behaviour; 

import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.RandomMovementBehaviour;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Entity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** 
* RandomMovementBehaviour Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class RandomMovementBehaviourTest { 
    @Test
    public void changesMovementDirection() {
        Movement movement = mock(Movement.class);
        Entity entity = mock(Entity.class);
        when(entity.getMovement()).thenReturn(movement);
        RandomMovementBehaviour behaviour = new RandomMovementBehaviour(1);
        behaviour.update(entity);
        verify(movement).setSpeedX(Mockito.anyFloat());
        verify(movement).setSpeedY(Mockito.anyFloat());
    }
}
