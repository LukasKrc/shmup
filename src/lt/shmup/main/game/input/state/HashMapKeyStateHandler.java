package lt.shmup.main.game.input.state;

import lt.shmup.main.game.input.KeyStateHandler;

import java.util.HashMap;

public class HashMapKeyStateHandler implements KeyStateHandler {

    /**
     * Keyboard key states (pressed, released)
     */
    private HashMap<Integer, Boolean> keyStates = new HashMap<>();

    @Override
    public boolean isKeyPressed(int keyCode) {
        return this.keyStates.getOrDefault(keyCode, false);
    }

    @Override
    public void setKeyState(int keyCode, boolean isPressed) {
        this.keyStates.put(keyCode, isPressed);
    }

}
