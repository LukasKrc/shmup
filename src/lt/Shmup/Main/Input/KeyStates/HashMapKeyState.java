package lt.Shmup.Main.Input.KeyStates;

import lt.Shmup.Main.Input.KeyState;

import java.util.HashMap;

public class HashMapKeyState implements KeyState {
    /**
     * Keyboard key states (Pressed, Released)
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
