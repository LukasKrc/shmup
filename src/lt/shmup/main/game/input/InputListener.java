package lt.shmup.main.game.input;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class InputListener {

    /**
     * Input events that get fired when keyboard input happens.
     */
    private LinkedList<InputEvent> keyPressedEvents = new LinkedList<>();
    private LinkedList<InputEvent> keyReleasedEvents = new LinkedList<>();

    /**
     * Game objects that gets manipulated by this input listener.
     */
    private GameObject gameObject;

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void addKeyPressedEvent(InputEvent inputEvent) {
        this.keyPressedEvents.add(inputEvent);
    }

    public void addKeyReleasedEvent(InputEvent inputEvent) {
        this.keyReleasedEvents.add(inputEvent);
    }

    public LinkedList<InputEvent> getKeyPressedInputEvents() {
        return keyPressedEvents;
    }

    public LinkedList<InputEvent> getKeyReleasedInputEvents() {
        return keyReleasedEvents;
    }

    public void removeKeyPressedEvent(InputEvent inputEvent) {
        this.keyPressedEvents.remove(inputEvent);
    }

    public void removeKeyReleasedEvent(InputEvent inputEvent) {
        this.keyReleasedEvents.remove(inputEvent);
    }

    public void fireKeyPressedEvents(KeyEvent keyEvent) {
        for (InputEvent inputEvent : this.keyPressedEvents) {
            inputEvent.handleKeyEvent(keyEvent, this.gameObject);
        }
    }

    public void fireKeyReleasedEvents(KeyEvent keyEvent) {
        for (InputEvent inputEvent : this.keyReleasedEvents) {
            inputEvent.handleKeyEvent(keyEvent, this.gameObject);
        }
    }
}
