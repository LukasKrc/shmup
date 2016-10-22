package lt.shmup.main.game.input;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.commands.CommandDispatcher;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    /**
     * Commands that get executed when the keyboard button indicated by the map key gets pressed.
     */
    private CommandDispatcher<Integer> keyPressedDispatcher;

    /**
     * The same as inputPressedCommands except they get executed when the key is released.
     */
    private CommandDispatcher<Integer> keyReleasedDispatcher;

    /**
     * Object that stores current key states.
     */
    private KeyStateHandler keyStateHandler;

    public KeyInputHandler(
        KeyStateHandler keyStateHandler,
        CommandDispatcher<Integer> keyPressedDispatcher,
        CommandDispatcher<Integer> keyReleasedDispatcher
    ) {
        this.keyStateHandler = keyStateHandler;
        this.keyPressedDispatcher = keyPressedDispatcher;
        this.keyReleasedDispatcher = keyReleasedDispatcher;
    }

    public void addKeyPressedCommand(int keyCode, Command command) {
        this.keyPressedDispatcher.addCommand(keyCode, command);
    }

    public void addKeyReleasedCommand(int keyCode, Command command) {
        this.keyReleasedDispatcher.addCommand(keyCode, command);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = this.getKeyCode(keyEvent);
        this.keyStateHandler.setKeyState(keyCode, true);
        this.keyPressedDispatcher.dispatchCommand(keyCode);
    }

    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = this.getKeyCode(keyEvent);
        this.keyStateHandler.setKeyState(keyCode, false);
        this.keyReleasedDispatcher.dispatchCommand(keyCode);
    }

    private int getKeyCode(KeyEvent keyEvent) {
        return keyEvent.getKeyCode();
    }
}
