package lt.Shmup.Main.Observers;

import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.Observer;

import java.util.HashMap;

public class ScoreIncreaseObserver implements Observer {
    private TextEntity textEntity;
    private int score = 0;

    public ScoreIncreaseObserver(TextEntity textEntity) {
        this.textEntity = textEntity;
    }

    @Override
    public void notify(String eventName, HashMap<String, String> data) {
        if (eventName.equals("enemy_destroyed")) {
            int scoreToAdd = Integer.parseInt(data.get("score"));
            score += scoreToAdd;
            textEntity.setText("Score: " + score);
        }
    }
}
