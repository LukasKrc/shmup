package lt.Shmup.Main.Command.Commands;

import lt.Shmup.Game;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.GameState;

public class StartGameCommand implements Command {
    private Game game;

    public StartGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.setGameState(GameState.Running);
    }
}
