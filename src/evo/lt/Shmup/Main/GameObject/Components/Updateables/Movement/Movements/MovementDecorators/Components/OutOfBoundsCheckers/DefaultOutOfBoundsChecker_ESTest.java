/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 13:38:15 GMT 2016
 */

package lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsCheckers;

import org.junit.Test;
import static org.junit.Assert.*;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsCheckers.DefaultOutOfBoundsChecker;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DefaultOutOfBoundsChecker_ESTest extends DefaultOutOfBoundsChecker_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isYOutOfBounds(768.0F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isYOutOfBounds((-744.4F));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isXOutOfBounds(1024.0F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isXOutOfBounds(0.0F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isYOutOfBounds(1868.0006F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isYOutOfBounds(1.0F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isYOutOfBounds(0.0F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isXOutOfBounds(175.4F);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isXOutOfBounds(2850.14F);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      DefaultOutOfBoundsChecker defaultOutOfBoundsChecker0 = new DefaultOutOfBoundsChecker();
      boolean boolean0 = defaultOutOfBoundsChecker0.isXOutOfBounds((-4724.1494F));
      assertTrue(boolean0);
  }
}