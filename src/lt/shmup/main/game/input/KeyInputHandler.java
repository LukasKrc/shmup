package lt.shmup.main.game.input;

import jdk.internal.util.xml.impl.Input;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyInputHandler extends KeyAdapter {

    /**
     * Game object handler.
     */
    private ObjectHandler objectHandler;

    /**
     * Current states of keyboard buttons (pressed, released).
     */
    private HashMap<Integer, Boolean> keyStates = new HashMap<>();

    public KeyInputHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    public void keyPressed(KeyEvent event) {
        this.keyStates.put(event.getKeyCode(), true);
        for (GameObject gameObject : this.objectHandler.getGameObjects()) {
            for (InputEvent inputEvent : gameObject.getInputEvents()) {
                inputEvent.handleKeyPressedEvent(event, this.keyStates);
            }
        }
    }

    public void keyReleased(KeyEvent event) {
        this.keyStates.put(event.getKeyCode(), false);
        for (GameObject gameObject : this.objectHandler.getGameObjects()) {
            for (InputEvent inputEvent : gameObject.getInputEvents()) {
                inputEvent.handleKeyReleasedEvent(event, this.keyStates);
            }
        }
    }

}
