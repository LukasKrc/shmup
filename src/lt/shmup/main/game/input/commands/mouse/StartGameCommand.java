package lt.shmup.main.game.input.commands.mouse;

import lt.shmup.main.Game;
import lt.shmup.main.game.Command;
import lt.shmup.main.game.GameState;

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
