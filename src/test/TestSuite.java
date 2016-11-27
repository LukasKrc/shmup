package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatchers.DefaultKeyboardCommandDispatcherTest;
import test.lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers.DefaultMouseCommandDispatcherTest;
import test.lt.Shmup.Main.Command.CommandStores.HashMapCommandStoreTest;
import test.lt.Shmup.Main.Command.Commands.PauseGameCommandTest;
import test.lt.Shmup.Main.Command.Commands.StartGameCommandTest;
import test.lt.Shmup.Main.Command.Commands.StopGameCommandTest;
import test.lt.Shmup.Main.EventTest;
import test.lt.Shmup.Main.GameObject.Builders.EntityBuilders.DefaultEntityBuilderTest;
import test.lt.Shmup.Main.GameObject.CollisionFinders.DefaultCollisionFinderTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.BasicBehaviourTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.SpawnerBehaviourTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollisions.DefaultHealthCollisionTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.DeathHealthTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.LinearMovementTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.ReflectDecoratorTest;
import test.lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.RemovalDecoratorTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        EventTest.class,
        DefaultKeyboardCommandDispatcherTest.class,
        DefaultMouseCommandDispatcherTest.class,
        PauseGameCommandTest.class,
        StartGameCommandTest.class,
        StopGameCommandTest.class,
        HashMapCommandStoreTest.class,
        DefaultEntityBuilderTest.class,
        DefaultCollisionFinderTest.class,
        BasicBehaviourTest.class,
        SpawnerBehaviourTest.class,
        DefaultHealthCollisionTest.class,
        DeathHealthTest.class,
        ReflectDecoratorTest.class,
        RemovalDecoratorTest.class,
        LinearMovementTest.class
})

public class TestSuite {
}
