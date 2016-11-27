/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:11:35 GMT 2016
 */

package lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released.StoppingHorizontalCommand;
import lt.Shmup.Main.Input.KeyState;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class StoppingHorizontalCommand_ESTest extends StoppingHorizontalCommand_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      StoppingHorizontalCommand stoppingHorizontalCommand0 = new StoppingHorizontalCommand((Entity) null, (KeyState) null, (-2195), (Command) null);
      // Undeclared exception!
      try { 
        stoppingHorizontalCommand0.setVelocity((Movement) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released.StoppingHorizontalCommand", e);
      }
  }
}
