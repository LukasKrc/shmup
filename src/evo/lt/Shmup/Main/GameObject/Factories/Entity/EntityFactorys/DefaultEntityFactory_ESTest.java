/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:20:25 GMT 2016
 */

package lt.Shmup.Main.GameObject.Factories.Entity.EntityFactorys;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactoryFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactorys.DefaultEntityFactory;
import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactory;
import lt.Shmup.Main.GameObject.Factories.RenderableFactory;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DefaultEntityFactory_ESTest extends DefaultEntityFactory_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DefaultEntityFactory defaultEntityFactory0 = null;
      try {
        defaultEntityFactory0 = new DefaultEntityFactory((RenderableFactory) null, (EntityBuilder) null, (ImageWrapperFactory) null, (EnemyFactoryFactory) null, (OutOfBoundsChecker) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Factories.Entity.EntityFactorys.DefaultEntityFactory", e);
      }
  }
}