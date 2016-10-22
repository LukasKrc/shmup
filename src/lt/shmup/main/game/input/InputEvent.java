package lt.shmup.main.game.input;

import lt.shmup.main.game.gameobject.GameObject;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public abstract class InputEvent {
    private GameObject gameObject;

    public abstract void handleKeyPressedEvent(
        KeyEvent keyEvent,
        HashMap<Integer, Boolean> keyStates
    );

    public abstract void handleKeyReleasedEvent(
        KeyEvent keyEvent,
        HashMap<Integer, Boolean> keyStates
    );

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public GameObject getGameObject() {
        return this.gameObject;
    }
}
