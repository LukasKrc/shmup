/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:22:08 GMT 2016
 */

package lt.Shmup.Main.Input.KeyStates;

import org.junit.Test;
import static org.junit.Assert.*;
import lt.Shmup.Main.Input.KeyStates.HashMapKeyState;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class HashMapKeyState_ESTest extends HashMapKeyState_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HashMapKeyState hashMapKeyState0 = new HashMapKeyState();
      hashMapKeyState0.setKeyState(0, true);
      boolean boolean0 = hashMapKeyState0.isKeyPressed(0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      HashMapKeyState hashMapKeyState0 = new HashMapKeyState();
      boolean boolean0 = hashMapKeyState0.isKeyPressed(2295);
      assertFalse(boolean0);
  }
}