package lt.Shmup.Main.Input.KeyboardInputHandlers;

import lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatcher;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Input.KeyState;
import lt.Shmup.Main.Input.KeyboardInputHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultKeyboardInputHandler extends KeyAdapter implements KeyboardInputHandler {
    /**
     * Commands that get executed when the Keyboard Mouse indicated by the map key gets Pressed.
     */
    private KeyboardCommandDispatcher keyPressedDispatcher;

    /**
     * The same as inputPressedCommands except they get executed when the key is Released.
     */
    private KeyboardCommandDispatcher keyReleasedDispatcher;

    /**
     * Object that stores current key states.
     */
    private KeyState keyState;

    public DefaultKeyboardInputHandler(
        KeyState keyState,
        KeyboardCommandDispatcher keyPressedDispatcher,
        KeyboardCommandDispatcher keyReleasedDispatcher
    ) {
        this.keyState = keyState;
        this.keyPressedDispatcher = keyPressedDispatcher;
        this.keyReleasedDispatcher = keyReleasedDispatcher;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = this.getKeyCode(keyEvent);
        this.keyState.setKeyState(keyCode, true);
        this.keyPressedDispatcher.dispatchCommand(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = this.getKeyCode(keyEvent);
        this.keyState.setKeyState(keyCode, false);
        this.keyReleasedDispatcher.dispatchCommand(keyCode);
    }

    private int getKeyCode(KeyEvent keyEvent) {
        return keyEvent.getKeyCode();
    }

    @Override
    public void addKeyPressedCommand(int key, Command command) {
        keyPressedDispatcher.getCommandStore().addCommand(key, command);
    }

    @Override
    public void addKeyReleasedCommand(int key, Command command) {
        keyReleasedDispatcher.getCommandStore().addCommand(key, command);
    }

    @Override
    public KeyState getKeyStateContainer() {
        return keyState;
    }
}
