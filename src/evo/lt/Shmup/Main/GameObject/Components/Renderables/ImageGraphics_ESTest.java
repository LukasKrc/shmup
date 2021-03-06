/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:28:47 GMT 2016
 */

package lt.Shmup.Main.GameObject.Components.Renderables;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Graphics2D;
import java.awt.Image;
import lt.Shmup.Main.GameObject.Components.Renderables.ImageGraphics;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Main.Graphics.ImageWrappers.DefaultImageWrapper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ImageGraphics_ESTest extends ImageGraphics_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) null);
      ImageWrapper imageWrapper0 = imageGraphics0.getImageWrapper();
      assertNull(imageWrapper0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 2313, 2313);
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) defaultImageWrapper0);
      DefaultImageWrapper defaultImageWrapper1 = (DefaultImageWrapper)imageGraphics0.getImageWrapper();
      assertSame(defaultImageWrapper1, defaultImageWrapper0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, (-3723), (-3723));
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) defaultImageWrapper0);
      DefaultImageWrapper defaultImageWrapper1 = (DefaultImageWrapper)imageGraphics0.getImageWrapper();
      assertEquals(-3723, defaultImageWrapper1.getWidth());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) null);
      // Undeclared exception!
      try { 
        imageGraphics0.clone();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Components.Renderables.ImageGraphics", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 0, 0);
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) defaultImageWrapper0);
      ImageGraphics imageGraphics1 = (ImageGraphics)imageGraphics0.clone();
      assertNotSame(imageGraphics0, imageGraphics1);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 0, 0);
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) defaultImageWrapper0);
      // Undeclared exception!
      try { 
        imageGraphics0.render((Graphics2D) null, (Entity) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Components.Renderables.ImageGraphics", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) null);
      // Undeclared exception!
      try { 
        imageGraphics0.drawImage((Graphics2D) null, (Image) null, (Position) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("lt.Shmup.Main.GameObject.Components.Renderables.ImageGraphics", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 0, 0);
      ImageGraphics imageGraphics0 = new ImageGraphics((ImageWrapper) defaultImageWrapper0);
      DefaultImageWrapper defaultImageWrapper1 = (DefaultImageWrapper)imageGraphics0.getImageWrapper();
      assertEquals(0, defaultImageWrapper1.getHeight());
  }
}
