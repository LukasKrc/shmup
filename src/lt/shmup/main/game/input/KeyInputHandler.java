package lt.shmup.main.game.input;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.ObjectHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    /**
     * Game object handler.
     */
    private ObjectHandler objectHandler;

    public KeyInputHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    public void keyPressed(KeyEvent event) {
        for (GameObject gameObject : this.objectHandler.getGameObjects()) {
            for (InputListener inputListener : gameObject.getInputListeners()) {
                inputListener.fireKeyPressedEvents(event);
            }
        }
    }

    public void keyReleased(KeyEvent event) {
        for (GameObject gameObject : this.objectHandler.getGameObjects()) {
            for (InputListener inputListener : gameObject.getInputListeners()) {
                inputListener.fireKeyReleasedEvents(event);
            }
        }
    }

}
