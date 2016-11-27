/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sun Nov 27 13:51:44 GMT 2016
 */

package lt.Shmup.Main.Command.Commands;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class StartGameCommand_ESTest_scaffolding {

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "lt.Shmup.Main.Command.Commands.StartGameCommand"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init(); 
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("java.vm.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.specification.version", "1.8"); 
            java.lang.System.setProperty("java.home", "/usr/lib/jvm/java-8-openjdk-amd64/jre"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.home", "/home/lukas"); 
                                        java.lang.System.setProperty("user.dir", "/media/lukas/1A1A680A1A67E0ED/Stuff/KTU/4 Kursas/Patternai/shmup"); 
    java.lang.System.setProperty("java.io.tmpdir", "/tmp"); 
    java.lang.System.setProperty("awt.toolkit", "sun.awt.X11.XToolkit"); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("file.separator", "/"); 
        java.lang.System.setProperty("java.awt.graphicsenv", "sun.awt.X11GraphicsEnvironment"); 
    java.lang.System.setProperty("java.awt.printerjob", "sun.print.PSPrinterJob"); 
    java.lang.System.setProperty("java.class.path", "/tmp/EvoSuite_pathingJar5267685820386100561.jar"); 
    java.lang.System.setProperty("java.class.version", "52.0"); 
        java.lang.System.setProperty("java.endorsed.dirs", "/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/endorsed"); 
    java.lang.System.setProperty("java.ext.dirs", "/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext:/usr/java/packages/lib/ext"); 
    java.lang.System.setProperty("java.library.path", "lib"); 
    java.lang.System.setProperty("java.runtime.name", "OpenJDK Runtime Environment"); 
    java.lang.System.setProperty("java.runtime.version", "1.8.0_111-8u111-b14-2ubuntu0.16.04.2-b14"); 
    java.lang.System.setProperty("java.specification.name", "Java Platform API Specification"); 
    java.lang.System.setProperty("java.specification.vendor", "Oracle Corporation"); 
        java.lang.System.setProperty("java.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vendor.url", "http://java.oracle.com/"); 
    java.lang.System.setProperty("java.version", "1.8.0_111"); 
    java.lang.System.setProperty("java.vm.info", "mixed mode"); 
    java.lang.System.setProperty("java.vm.name", "OpenJDK 64-Bit Server VM"); 
    java.lang.System.setProperty("java.vm.specification.name", "Java Virtual Machine Specification"); 
    java.lang.System.setProperty("java.vm.specification.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vm.specification.version", "1.8"); 
    java.lang.System.setProperty("java.vm.version", "25.111-b14"); 
    java.lang.System.setProperty("line.separator", "\n"); 
    java.lang.System.setProperty("os.arch", "amd64"); 
    java.lang.System.setProperty("os.name", "Linux"); 
    java.lang.System.setProperty("os.version", "4.4.0-47-generic"); 
    java.lang.System.setProperty("path.separator", ":"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "lukas"); 
    java.lang.System.setProperty("user.timezone", "Europe/Vilnius"); 
          }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(StartGameCommand_ESTest_scaffolding.class.getClassLoader() ,
      "com.google.gson.internal.bind.TimeTypeAdapter$1",
      "com.google.gson.reflect.TypeToken",
      "com.google.gson.internal.bind.TypeAdapters$23",
      "com.google.gson.internal.bind.TypeAdapters$24",
      "com.google.gson.internal.bind.TypeAdapters$25",
      "com.google.gson.internal.bind.TypeAdapters$26",
      "lt.Shmup.Config",
      "com.google.gson.internal.bind.TypeAdapters$20",
      "com.google.gson.TypeAdapter",
      "com.google.gson.internal.bind.TypeAdapters$21",
      "com.google.gson.internal.bind.JsonTreeWriter",
      "com.google.gson.internal.bind.TypeAdapters$22",
      "com.google.gson.internal.bind.TypeAdapters$27",
      "com.google.gson.internal.bind.TypeAdapters$28",
      "com.google.gson.FieldNamingStrategy",
      "com.google.gson.internal.bind.TypeAdapters$29",
      "com.google.gson.internal.bind.SqlDateTypeAdapter",
      "com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper",
      "com.google.gson.ExclusionStrategy",
      "com.google.gson.internal.bind.TimeTypeAdapter",
      "com.google.gson.internal.bind.TypeAdapters$34",
      "com.google.gson.internal.bind.TypeAdapters$35",
      "com.google.gson.internal.bind.TypeAdapters$36",
      "com.google.gson.internal.bind.TypeAdapters$30",
      "com.google.gson.internal.bind.TypeAdapters$32",
      "com.google.gson.internal.bind.TypeAdapters$33",
      "com.google.gson.JsonArray",
      "com.google.gson.LongSerializationPolicy",
      "com.google.gson.internal.bind.TypeAdapters$35$1",
      "com.google.gson.internal.Excluder",
      "com.google.gson.annotations.Until",
      "com.google.gson.TypeAdapterFactory",
      "com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter",
      "com.google.gson.stream.JsonReader$1",
      "com.google.gson.internal.$Gson$Types",
      "com.google.gson.stream.JsonReader",
      "lt.Shmup.Game",
      "com.google.gson.Gson$FutureTypeAdapter",
      "lt.Shmup.Main.GameState",
      "com.google.gson.internal.LinkedTreeMap$Node",
      "com.google.gson.stream.JsonWriter",
      "com.google.gson.internal.bind.ArrayTypeAdapter$1",
      "lt.Shmup.Main.Command.Commands.StartGameCommand",
      "com.google.gson.internal.bind.TypeAdapters$12",
      "com.google.gson.internal.bind.TypeAdapters$13",
      "com.google.gson.internal.bind.TypeAdapters$14",
      "com.google.gson.internal.bind.TypeAdapters$15",
      "com.google.gson.internal.bind.TypeAdapters$10",
      "com.google.gson.internal.bind.TypeAdapters$11",
      "com.google.gson.stream.MalformedJsonException",
      "com.google.gson.internal.bind.ArrayTypeAdapter",
      "com.google.gson.stream.JsonToken",
      "com.google.gson.internal.bind.TypeAdapters$16",
      "com.google.gson.internal.bind.TypeAdapters$17",
      "com.google.gson.internal.bind.TypeAdapters$18",
      "com.google.gson.internal.bind.TypeAdapters$19",
      "com.google.gson.JsonNull",
      "com.google.gson.internal.bind.DateTypeAdapter$1",
      "com.google.gson.LongSerializationPolicy$1",
      "com.google.gson.LongSerializationPolicy$2",
      "com.google.gson.JsonObject",
      "com.google.gson.TypeAdapter$1",
      "com.google.gson.Gson$2",
      "com.google.gson.Gson$3",
      "com.google.gson.internal.bind.ObjectTypeAdapter",
      "com.google.gson.Gson$4",
      "com.google.gson.internal.bind.DateTypeAdapter",
      "com.google.gson.Gson$1",
      "com.google.gson.internal.bind.TypeAdapters$26$1",
      "com.google.gson.Gson",
      "com.google.gson.internal.LinkedTreeMap$1",
      "lt.Shmup.Main.Command.Command",
      "com.google.gson.internal.bind.TypeAdapters$2",
      "com.google.gson.internal.Excluder$1",
      "com.google.gson.internal.bind.TypeAdapters$1",
      "com.google.gson.internal.bind.JsonTreeReader",
      "com.google.gson.internal.bind.SqlDateTypeAdapter$1",
      "com.google.gson.JsonIOException",
      "com.google.gson.internal.bind.TypeAdapters$8",
      "com.google.gson.internal.bind.TypeAdapters$7",
      "com.google.gson.internal.bind.TypeAdapters",
      "com.google.gson.internal.bind.TypeAdapters$9",
      "com.google.gson.internal.bind.TypeAdapters$4",
      "com.google.gson.internal.LinkedTreeMap",
      "com.google.gson.internal.bind.TypeAdapters$3",
      "com.google.gson.internal.bind.TypeAdapters$6",
      "com.google.gson.internal.bind.TypeAdapters$5",
      "com.google.gson.internal.LazilyParsedNumber",
      "com.google.gson.internal.bind.ObjectTypeAdapter$1",
      "com.google.gson.JsonParseException",
      "com.google.gson.JsonElement",
      "com.google.gson.FieldNamingPolicy",
      "com.google.gson.JsonPrimitive",
      "com.google.gson.JsonSyntaxException",
      "com.google.gson.FieldNamingPolicy$4",
      "com.google.gson.FieldNamingPolicy$3",
      "com.google.gson.annotations.Since",
      "com.google.gson.FieldNamingPolicy$5",
      "com.google.gson.internal.JsonReaderInternalAccess",
      "com.google.gson.FieldNamingPolicy$2",
      "com.google.gson.FieldNamingPolicy$1"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(StartGameCommand_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "lt.Shmup.Main.GameState",
      "lt.Shmup.Config",
      "com.google.gson.internal.JsonReaderInternalAccess",
      "com.google.gson.stream.JsonReader",
      "com.google.gson.stream.JsonToken",
      "com.google.gson.internal.bind.TypeAdapters$27",
      "com.google.gson.internal.bind.TypeAdapters",
      "com.google.gson.internal.bind.TypeAdapters$36",
      "com.google.gson.internal.LinkedTreeMap",
      "com.google.gson.JsonPrimitive",
      "com.google.gson.internal.LazilyParsedNumber",
      "com.google.gson.internal.$Gson$Types",
      "com.google.gson.Gson",
      "com.google.gson.internal.Excluder",
      "com.google.gson.FieldNamingPolicy$1",
      "com.google.gson.FieldNamingPolicy$2",
      "com.google.gson.FieldNamingPolicy$3",
      "com.google.gson.FieldNamingPolicy$4",
      "com.google.gson.FieldNamingPolicy$5",
      "com.google.gson.FieldNamingPolicy",
      "com.google.gson.LongSerializationPolicy$1",
      "com.google.gson.LongSerializationPolicy$2",
      "com.google.gson.LongSerializationPolicy",
      "com.google.gson.internal.bind.ObjectTypeAdapter",
      "com.google.gson.internal.bind.DateTypeAdapter",
      "com.google.gson.internal.bind.TimeTypeAdapter",
      "com.google.gson.internal.bind.SqlDateTypeAdapter",
      "com.google.gson.internal.bind.ArrayTypeAdapter"
    );
  }
}
