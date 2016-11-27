/*
 * This file was automatically generated by EvoSuite
 * Sun Nov 27 14:10:09 GMT 2016
 */

package lt.Shmup.Main.GameObject.Factories.ImageWrapperFactorys;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Color;
import java.awt.Image;
import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactorys.DefaultImageWrapperFactory;
import lt.Shmup.Main.Graphics.ImageReader;
import lt.Shmup.Main.Graphics.ImageReaders.DefaultImageReader;
import lt.Shmup.Main.Graphics.ImageWrappers.Decorators.FlashingImageWrapperDecorator;
import lt.Shmup.Main.Graphics.ImageWrappers.DefaultImageWrapper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class DefaultImageWrapperFactory_ESTest extends DefaultImageWrapperFactory_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DefaultImageWrapperFactory defaultImageWrapperFactory0 = new DefaultImageWrapperFactory((ImageReader) null);
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 0, 0);
      FlashingImageWrapperDecorator flashingImageWrapperDecorator0 = defaultImageWrapperFactory0.getFlashingImageWrapper(defaultImageWrapper0, 1076.7936F, 0, (Color) null);
      assertEquals(0, flashingImageWrapperDecorator0.getHeight());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      DefaultImageReader defaultImageReader0 = new DefaultImageReader();
      DefaultImageWrapperFactory defaultImageWrapperFactory0 = new DefaultImageWrapperFactory((ImageReader) defaultImageReader0);
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, 607, 607);
      FlashingImageWrapperDecorator flashingImageWrapperDecorator0 = defaultImageWrapperFactory0.getFlashingImageWrapper(defaultImageWrapper0, 607, (-2799.124F), (Color) null);
      assertEquals(607, flashingImageWrapperDecorator0.getWidth());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DefaultImageReader defaultImageReader0 = new DefaultImageReader();
      DefaultImageWrapperFactory defaultImageWrapperFactory0 = new DefaultImageWrapperFactory((ImageReader) defaultImageReader0);
      // Undeclared exception!
      try { 
        defaultImageWrapperFactory0.getDefaultImageWrapper(" .|~D?w-", 2, 2);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // input == null!
         //
         assertThrownBy("javax.imageio.ImageIO", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DefaultImageReader defaultImageReader0 = new DefaultImageReader();
      DefaultImageWrapperFactory defaultImageWrapperFactory0 = new DefaultImageWrapperFactory((ImageReader) defaultImageReader0);
      DefaultImageWrapper defaultImageWrapper0 = new DefaultImageWrapper((Image) null, (-5624), (-5624));
      Color color0 = Color.white;
      FlashingImageWrapperDecorator flashingImageWrapperDecorator0 = defaultImageWrapperFactory0.getFlashingImageWrapper(defaultImageWrapper0, 3578.0F, (-1165.7853F), color0);
      assertEquals(-5624, flashingImageWrapperDecorator0.getWidth());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      DefaultImageReader defaultImageReader0 = new DefaultImageReader();
      DefaultImageWrapperFactory defaultImageWrapperFactory0 = new DefaultImageWrapperFactory((ImageReader) defaultImageReader0);
      // Undeclared exception!
      try { 
        defaultImageWrapperFactory0.getDefaultImageWrapper((String) null, (-1130), (-151));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }
}