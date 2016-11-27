package test.lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions; 

import lt.Shmup.Container;
import lt.Shmup.Main.ClassRegistrator;
import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Builders.EntityBuilders.DefaultEntityBuilder;
import lt.Shmup.Main.GameObject.Builders.NullCreators.DefaultNullCreator;
import lt.Shmup.Main.GameObject.CollisionFinder;
import lt.Shmup.Main.GameObject.CollisionFinders.DefaultCollisionFinder;
import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderers.DefaultTextRenderer;
import lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions.DefaultHealthCollision;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.ObjectHandlers.DefaultObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Visitors.DefaultVisitor;
import lt.Shmup.Main.Graphics.TextCenterers.DefaultTextCenterer;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import static org.mockito.Mockito.*;

/** 
* DefaultHealthCollision Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 27, 2016</pre> 
* @version 1.0 
*/ 
public class DefaultHealthCollisionTest {
    private EntityBuilder entityBuilder;

    public DefaultHealthCollisionTest() {
        entityBuilder = new DefaultEntityBuilder(new DefaultNullCreator());
    }

    @Test
    public void friendlyProjectilesDoNotCollide() {
        testProjectileCollision(Identifier.PlayerProjectile, Identifier.PlayerProjectile, false);
    }

    @Test
    public void hostileProjectilesCollide() {
        testProjectileCollision(Identifier.PlayerProjectile, Identifier.EnemyProjectile, true);
    }

    @Test
    public void collisionCausesDamage() {
        int damage = 10;
        DamageCausingEntity firstEntity = mock(DamageCausingEntity.class);
        when(firstEntity.getCollisionDamage()).thenReturn(damage);
        DamageCausingEntity secondEntity = mock(DamageCausingEntity.class);
        when(firstEntity.getIdentifier()).thenReturn(Identifier.Player);
        when(secondEntity.getIdentifier()).thenReturn(Identifier.Enemy);
        CollisionFinder collisionFinder = mock(CollisionFinder.class);
        when(collisionFinder.getCollidedEntities(firstEntity))
                .thenReturn(new LinkedList<Entity>(Arrays.asList(secondEntity)));
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        when(objectHandler.getCollisionFinder()).thenReturn(collisionFinder);
        when(firstEntity.getObjectHandler()).thenReturn(objectHandler);
        DefaultHealthCollision healthCollision = new DefaultHealthCollision();
        healthCollision.update(firstEntity);
        HashMap<String, String> damageData = new HashMap<>();
        damageData.put("damage", String.valueOf(damage));
        verify(secondEntity).notifyObservers("damage_taken", damageData);
    }

    private void testProjectileCollision(
            Identifier firstIdentifier,
            Identifier secondIdentifier,
            boolean shouldCollide
    ) {
        DamageCausingEntity firstProjectile = mock(DamageCausingEntity.class);
        DamageCausingEntity secondProjectile = mock(DamageCausingEntity.class);
        when(firstProjectile.getIdentifier()).thenReturn(firstIdentifier);
        when(secondProjectile.getIdentifier()).thenReturn(secondIdentifier);
        CollisionFinder collisionFinder = mock(CollisionFinder.class);
        when(collisionFinder.getCollidedEntities(firstProjectile))
                .thenReturn(new LinkedList<Entity>(Arrays.asList(secondProjectile)));
        ObjectHandler objectHandler = mock(ObjectHandler.class);
        when(objectHandler.getCollisionFinder()).thenReturn(collisionFinder);
        when(firstProjectile.getObjectHandler()).thenReturn(objectHandler);
        DefaultHealthCollision healthCollision = new DefaultHealthCollision();
        healthCollision.update(firstProjectile);
        if (shouldCollide) {
            verify(firstProjectile).notifyObservers(eq("damage_taken"), Mockito.any());
        } else {
            verify(firstProjectile, never()).notifyObservers(eq("damage_taken"), Mockito.any());
        }
    }
}
