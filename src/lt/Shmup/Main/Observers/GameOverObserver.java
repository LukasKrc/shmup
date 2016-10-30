package lt.Shmup.Main.Observers;

import lt.Shmup.Game;
import lt.Shmup.Main.GameState;
import lt.Shmup.Main.Observer;

import java.util.HashMap;

public class GameOverObserver implements Observer {
    private Game game;

    public GameOverObserver(Game game) {
        this.game = game;
    }

    @Override
    public void notify(String eventName, HashMap<String, String> data) {
        if (eventName.equals("player_destroyed")) {
            game.setGameState(GameState.Over);
        }
    }
}
