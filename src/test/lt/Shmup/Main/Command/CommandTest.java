package test.lt.Shmup.Main.Command;

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.Commands.PauseGameCommand;
import lt.Shmup.Main.GameState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class CommandTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: execute()
     *
     */
    @Test
    public void gameGetsPaused() throws Exception {
        Game game = mock(Game.class);
        Command command = this.getCommand(game);
        command.execute();
        verify(game).setGameState(this.getExpectedGameState());
    }

    public abstract Command getCommand(Game game);
    public abstract GameState getExpectedGameState();
}
