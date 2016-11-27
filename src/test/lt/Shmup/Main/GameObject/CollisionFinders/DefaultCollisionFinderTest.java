package test.lt.Shmup.Main.GameObject.CollisionFinders; 

import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Builders.EntityBuilders.DefaultEntityBuilder;
import lt.Shmup.Main.GameObject.Builders.NullCreators.DefaultNullCreator;
import lt.Shmup.Main.GameObject.CollisionFinder;
import lt.Shmup.Main.GameObject.CollisionFinders.DefaultCollisionFinder;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;
import lt.Shmup.Main.GameObject.Objects.Entity;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.testng.AssertJUnit.assertEquals;

/** 
* DefaultCollisionFinder Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class DefaultCollisionFinderTest {
    private CollisionFinder collisionFinder;
    private EntityBuilder entityBuilder;

    public DefaultCollisionFinderTest() {
        entityBuilder = new DefaultEntityBuilder(new DefaultNullCreator());
    }

    @Before
    public void before() {
        collisionFinder = new DefaultCollisionFinder();
    }

    @Test
    public void returnsOverlapingEntitiesWhenMainEntitysAreCollidable() {
        Entity mainEntity = getCollidableEntity();
        setCollisionData(mainEntity, 0, 0, 10, 10);
        Entity secondaryEntity = getCollidableEntity();
        setCollisionData(secondaryEntity, 0, 0, 10, 10);
        collisionFinder.addEntity(secondaryEntity);
        List<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(mainEntity);
        assertSame(secondaryEntity, collidedEntities.get(0));
    }

    @Test
    public void returnsNothingWhenEntityIsNotCollidable() {
        Entity mainEntity = getNonCollidableEntity();
        setCollisionData(mainEntity, 0, 0, 10, 10);
        Entity secondaryEntity = getCollidableEntity();
        setCollisionData(secondaryEntity, 0, 0, 10, 10);
        collisionFinder.addEntity(secondaryEntity);
        List<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(mainEntity);
        assertEquals(true, collidedEntities.isEmpty());
    }

    @Test
    public void returnsTouchingEntitiesWhenBothAreCollidable() {
        Entity mainEntity = getCollidableEntity();
        setCollisionData(mainEntity, 0, 0, 10, 10);
        Entity secondaryEntity = getCollidableEntity();
        setCollisionData(secondaryEntity, 10, 10, 10, 10);
        collisionFinder.addEntity(secondaryEntity);
        List<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(mainEntity);
        assertSame(secondaryEntity, collidedEntities.get(0));
    }

    @Test
    public void returnsNothingWhenEntitiesAreNotOverlapingOrTouching() {
        Entity mainEntity = getCollidableEntity();
        setCollisionData(mainEntity, 0, 0, 10, 10);
        Entity secondaryEntity = getCollidableEntity();
        setCollisionData(secondaryEntity, 11, 11, 10, 10);
        collisionFinder.addEntity(secondaryEntity);
        List<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(mainEntity);
        assertEquals(true, collidedEntities.isEmpty());
    }

    @Test
    public void returnsNothingWhenEntityIsRemvoed() {
        Entity mainEntity = getCollidableEntity();
        setCollisionData(mainEntity, 0, 0, 10, 10);
        Entity secondaryEntity = getCollidableEntity();
        setCollisionData(secondaryEntity, 0, 0, 10, 10);
        collisionFinder.addEntity(secondaryEntity);
        collisionFinder.removeEntity(secondaryEntity);
        List<Entity> collidedEntities =
                collisionFinder.getCollidedEntities(mainEntity);
        assertEquals(true, collidedEntities.isEmpty());
    }

    private Entity getCollidableEntity() {
        entityBuilder.setIsCollidable(true);
        return entityBuilder.getEntity(EntityBuilder.RESET_ALL);
    }

    private Entity getNonCollidableEntity() {
        entityBuilder.setIsCollidable(false);
        return entityBuilder.getEntity(EntityBuilder.RESET_ALL);
    }

    private void setCollisionData(Entity entity, int x, int y, int width, int height) {
        entity.setPosition(new BasicPosition(x, y));
        entity.setVolume(new BasicVolume(width, height));
    }
}
