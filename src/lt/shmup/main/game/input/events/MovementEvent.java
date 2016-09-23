package lt.shmup.main.game.input.events;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.input.InputEvent;

import java.awt.event.KeyEvent;

public abstract class MovementEvent implements InputEvent {

    public void handleKeyEvent(KeyEvent keyEvent, GameObject gameObject) {
        int keyCode = keyEvent.getKeyCode();
        this.updateGameObjectVelocities(keyCode, gameObject);
    }

    private void updateGameObjectVelocities(
            int keyCode,
            GameObject gameObject
    ) {
        switch (keyCode) {
            case KeyEvent.VK_W :
                gameObject.setVelocityY(-this.getVelocityY());
                break;
            case KeyEvent.VK_S :
                gameObject.setVelocityY(this.getVelocityY());
                break;
            case KeyEvent.VK_A :
                gameObject.setVelocityX(-this.getVelocityX());
                break;
            case KeyEvent.VK_D :
                gameObject.setVelocityX(this.getVelocityX());
                break;
        }
    }

    protected abstract int getVelocityY();
    protected abstract int getVelocityX();
}
