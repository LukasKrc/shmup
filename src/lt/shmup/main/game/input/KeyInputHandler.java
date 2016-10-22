package lt.shmup.main.game.input;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.gameobject.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

public class KeyInputHandler extends KeyAdapter {

    /**
     * Commands that get executed when the keyboard button indicated by the map key gets pressed.
     */
    private HashMap<Integer, LinkedList<Command>> keyPressedCommands = new HashMap<>();

    /**
     * The same as inputPressedCommands except they get executed when the key is released.
     */
    private HashMap<Integer, LinkedList<Command>> keyReleasedCommands = new HashMap<>();

    /**
     * Object that stores current key states.
     */
    private KeyStateHandler keyStateHandler;

    public KeyInputHandler(KeyStateHandler keyStateHandler) {
        this.keyStateHandler = keyStateHandler;
    }

    public void addKeyPressedCommand(int keyCode, Command command) {
        this.keyPressedCommands.putIfAbsent(keyCode, new LinkedList<>());
        this.keyPressedCommands.get(keyCode).add(command);
    }

    public void addKeyReleasedCommand(int keyCode, Command command) {
        this.keyReleasedCommands.putIfAbsent(keyCode, new LinkedList<>());
        this.keyReleasedCommands.get(keyCode).add(command);
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        this.keyStateHandler.setKeyState(keyCode, true);
        for (Command keyPressedCommand : this.keyPressedCommands.getOrDefault(keyCode, new LinkedList<>())) {
            keyPressedCommand.execute();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        this.keyStateHandler.setKeyState(keyCode, false);
        for (Command keyReleasedCommand : this.keyReleasedCommands.getOrDefault(keyCode, new LinkedList<>())) {
            keyReleasedCommand.execute();
        }
    }

}
