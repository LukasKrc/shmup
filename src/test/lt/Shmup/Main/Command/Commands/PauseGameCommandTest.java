package test.lt.Shmup.Main.Command.Commands; 

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.Commands.PauseGameCommand;
import lt.Shmup.Main.GameState;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import test.lt.Shmup.Main.Command.CommandTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/** 
* PauseGameCommand Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class PauseGameCommandTest extends CommandTest {
    @Override
    public Command getCommand(Game game) {
        return new PauseGameCommand(game);
    }

    @Override
    public GameState getExpectedGameState() {
        return GameState.Paused;
    }
} 
