/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 13:36:20 GMT 2016
 */

package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.ReflectDecorator;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class OutOfBoundsDecorator_ESTest extends OutOfBoundsDecorator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      boolean boolean0 = reflectDecorator0.isXTouchingBound();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      boolean boolean0 = reflectDecorator0.isYTouchingBound();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      boolean boolean0 = reflectDecorator0.isyOutOfBounds();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      boolean boolean0 = reflectDecorator0.isxOutOfBounds();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      Identifier identifier0 = Identifier.Enemy;
      Entity entity0 = new Entity(0, identifier0, (Position) null, (Volume) null, (Health) null, (Movement) reflectDecorator0, (Updateable) null, (Renderable) null, false);
      reflectDecorator0.decorate(entity0);
      assertFalse(reflectDecorator0.isyOutOfBounds());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      Identifier identifier0 = Identifier.Enemy;
      Entity entity0 = new Entity((-2867), identifier0, (Position) null, (Volume) null, (Health) null, (Movement) null, (Updateable) null, (Renderable) null, true);
      // Undeclared exception!
      try { 
        reflectDecorator0.update(entity0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorator", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ReflectDecorator reflectDecorator0 = new ReflectDecorator((Movement) null, (OutOfBoundsChecker) null);
      OutOfBoundsChecker outOfBoundsChecker0 = reflectDecorator0.getOutOfBoundsChecker();
      assertNull(outOfBoundsChecker0);
  }
}
