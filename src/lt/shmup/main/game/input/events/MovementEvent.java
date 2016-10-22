package lt.shmup.main.game.input.events;

import lt.shmup.main.game.input.InputEvent;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class MovementEvent extends InputEvent {

    private int velocityX;
    private int velocityY;

    public MovementEvent(int velocityX, int velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    @Override
    public void handleKeyPressedEvent(KeyEvent keyEvent, HashMap<Integer, Boolean> keyStates) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W :
                this.getGameObject().setVelocityY(-this.velocityY);
                break;
            case KeyEvent.VK_S :
                this.getGameObject().setVelocityY(this.velocityY);
                break;
            case KeyEvent.VK_A :
                this.getGameObject().setVelocityX(-this.velocityX);
                break;
            case KeyEvent.VK_D :
                this.getGameObject().setVelocityX(this.velocityX);
                break;
        }
    }

    @Override
    public void handleKeyReleasedEvent(KeyEvent keyEvent, HashMap<Integer, Boolean> keyStates) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W :
                if (keyStates.getOrDefault(KeyEvent.VK_S, false)) {
                    this.getGameObject().setVelocityY(-this.velocityY);
                } else {
                    this.getGameObject().setVelocityY(0);
                }
                break;
            case KeyEvent.VK_S :
                if (keyStates.getOrDefault(KeyEvent.VK_W, false)) {
                    this.getGameObject().setVelocityY(this.velocityY);
                } else {
                    this.getGameObject().setVelocityY(0);
                }
                break;
            case KeyEvent.VK_A :
                if (keyStates.getOrDefault(KeyEvent.VK_D, false)) {
                    this.getGameObject().setVelocityX(this.velocityX);
                } else {
                    this.getGameObject().setVelocityX(0);
                }
                break;
            case KeyEvent.VK_D :
                if (keyStates.getOrDefault(KeyEvent.VK_A, false)) {
                    this.getGameObject().setVelocityX(-this.velocityX);
                } else {
                    this.getGameObject().setVelocityX(0);
                }
                break;
        }
    }
}
