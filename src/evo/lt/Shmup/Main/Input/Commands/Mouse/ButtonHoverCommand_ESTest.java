/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 13:59:27 GMT 2016
 */

package lt.Shmup.Main.Input.Commands.Mouse;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.event.MouseEvent;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.Input.Commands.Mouse.ButtonHoverCommand;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ButtonHoverCommand_ESTest extends ButtonHoverCommand_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ButtonHoverCommand buttonHoverCommand0 = new ButtonHoverCommand((ButtonEntity) null);
      // Undeclared exception!
      try { 
        buttonHoverCommand0.execute((MouseEvent) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.Input.Commands.Mouse.ButtonHoverCommand", e);
      }
  }
}