/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 13:53:13 GMT 2016
 */

package lt.Shmup.Main.Observers;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.HashMap;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.Observers.ScoreIncreaseObserver;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ScoreIncreaseObserver_ESTest extends ScoreIncreaseObserver_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ScoreIncreaseObserver scoreIncreaseObserver0 = new ScoreIncreaseObserver((TextEntity) null);
      // Undeclared exception!
      try { 
        scoreIncreaseObserver0.notify("enemy_destroyed", (HashMap<String, String>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.Observers.ScoreIncreaseObserver", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ScoreIncreaseObserver scoreIncreaseObserver0 = new ScoreIncreaseObserver((TextEntity) null);
      scoreIncreaseObserver0.notify("enemy]destroyed", (HashMap<String, String>) null);
  }
}