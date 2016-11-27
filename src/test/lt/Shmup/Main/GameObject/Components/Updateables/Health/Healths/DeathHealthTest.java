package test.lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths; 

import lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.DeathHealth;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Updateable;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** 
* DeathHealth Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class DeathHealthTest {
    @Test
    public void entityGetsRemovedOnDestruction() {
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        Entity entity = mock(Entity.class);
        when(entity.getObjectHandler()).thenReturn(objectHandler);
        Updateable health = new DeathHealth(0, 100, 0);
        health.update(entity);
        verify(objectHandler).removeEntity(entity);
    }
} 
