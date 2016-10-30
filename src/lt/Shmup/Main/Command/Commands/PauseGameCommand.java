package lt.Shmup.Main.Command.Commands;

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameState;

public class PauseGameCommand implements Command {
    private Game game;

    public PauseGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        this.game.setGameState(GameState.Paused);
    }
}
