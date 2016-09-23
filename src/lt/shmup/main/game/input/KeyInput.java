package lt.shmup.main.game.input;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private ObjectHandler objectHandler;

    public KeyInput(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        for (GameObject object : objectHandler.getGameObjects()) {
            if (object.getIdentifier() == Identifier.Player) {
                if (keyCode == KeyEvent.VK_W) {
                    object.setY(object.getY() - 1);
                }
            }
        }
    }

    public void keyReleased(KeyEvent event) {
        int keyCode = event.getKeyCode();
    }

}
