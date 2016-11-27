/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 13:51:44 GMT 2016
 */

package lt.Shmup.Main.Command.Commands;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import lt.Shmup.Game;
import lt.Shmup.Main.Command.Commands.StartGameCommand;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class StartGameCommand_ESTest extends StartGameCommand_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      StartGameCommand startGameCommand0 = new StartGameCommand((Game) null);
      // Undeclared exception!
      try { 
        startGameCommand0.execute();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.Command.Commands.StartGameCommand", e);
      }
  }
}