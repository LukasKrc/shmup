package test.lt.Shmup.Main.GameObject.Components.Updateables.Behaviour; 

import lt.Shmup.Main.ClassRegistrator;
import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.SpawnerBehaviour;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactory;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.*;

/** 
* SpawnerBehaviour Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class SpawnerBehaviourTest {
    @Before
    public void before() {
        (new ClassRegistrator()).createMainDependencies();
    }

    @Test
    public void spawnsEnemies() {
        DamageCausingEntity randomEntity = mock(DamageCausingEntity.class);
        DamageCausingEntity basicEntityClone = mock(DamageCausingEntity.class);
        DamageCausingEntity basicEntity = mock(DamageCausingEntity.class);
        when(basicEntity.clone()).thenReturn(basicEntityClone);
        EntityFactory entityFactory = mock(EntityFactory.class);
        when(entityFactory.getBasicEnemy()).thenReturn(basicEntity);
        when(entityFactory.getRandomEnemy()).thenReturn(randomEntity);
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        Entity entity = mock(Entity.class);
        when(entity.getObjectHandler()).thenReturn(objectHandler);
        SpawnerBehaviour spawnerBehaviour = new SpawnerBehaviour(entityFactory, 1, 1);
        spawnerBehaviour.update(entity);
        verify(objectHandler, times(2)).addEntity(randomEntity);
        verify(objectHandler, times(2)).addEntity(basicEntityClone);
        verify(objectHandler, times(2)).addEntity(basicEntity);
    }
} 
