package lt.shmup.main.game.input;

import lt.shmup.main.game.gameobject.GameObject;

import java.awt.event.KeyEvent;

public interface InputEvent {
    public void handleKeyEvent(
            KeyEvent keyEvent,
            GameObject gameObject
    );
}
