package test.lt.Shmup.Main.Command.Commands; 

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.Commands.StartGameCommand;
import lt.Shmup.Main.GameState;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import test.lt.Shmup.Main.Command.CommandTest;

/** 
* StartGameCommand Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class StartGameCommandTest extends CommandTest {
    @Override
    public Command getCommand(Game game) {
        return new StartGameCommand(game);
    }

    @Override
    public GameState getExpectedGameState() {
        return GameState.Running;
    }
} 
