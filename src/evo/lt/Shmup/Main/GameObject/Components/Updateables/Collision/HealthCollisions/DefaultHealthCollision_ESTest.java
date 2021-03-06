/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:15:54 GMT 2016
 */

package lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions.DefaultHealthCollision;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DefaultHealthCollision_ESTest extends DefaultHealthCollision_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DefaultHealthCollision defaultHealthCollision0 = new DefaultHealthCollision();
      // Undeclared exception!
      try { 
        defaultHealthCollision0.update((DamageCausingEntity) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions.DefaultHealthCollision", e);
      }
  }
}
