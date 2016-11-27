/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:08:00 GMT 2016
 */

package lt.Shmup.Main.GameObject.Objects.Entities;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import lt.Shmup.Main.GameObject.Visitor;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DamageCausingEntity_ESTest extends DamageCausingEntity_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Identifier identifier0 = Identifier.EnemyProjectile;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(1, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, true, 0);
      assertEquals(0, damageCausingEntity0.getCollisionDamage());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Identifier identifier0 = Identifier.Enemy;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(957, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, false, 957);
      int int0 = damageCausingEntity0.getCollisionDamage();
      assertEquals(957, int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Identifier identifier0 = Identifier.Unidentified;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity((-559), identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, true, (-559));
      int int0 = damageCausingEntity0.getCollisionDamage();
      assertEquals((-559), int0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Identifier identifier0 = Identifier.Enemy;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(957, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, false, 957);
      damageCausingEntity0.setCollisionDamage(957);
      assertEquals(957, damageCausingEntity0.getCollisionDamage());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Identifier identifier0 = Identifier.Enemy;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(957, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, false, 957);
      // Undeclared exception!
      try { 
        damageCausingEntity0.acceptUpdateVisitor((Visitor) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Identifier identifier0 = Identifier.Enemy;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(0, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, true, 0);
      int int0 = damageCausingEntity0.getCollisionDamage();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Identifier identifier0 = Identifier.PlayerProjectile;
      DamageCausingEntity damageCausingEntity0 = new DamageCausingEntity(897, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, false, (-274), (LinkedList<EntityObserver>) null);
      // Undeclared exception!
      try { 
        damageCausingEntity0.clone();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity", e);
      }
  }
}
