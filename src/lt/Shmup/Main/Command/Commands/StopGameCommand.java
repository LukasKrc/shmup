package lt.Shmup.Main.Command.Commands;

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameState;

public class StopGameCommand implements Command {

    private Game game;

    public StopGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        this.game.setGameState(GameState.Stopped);
    }
}
