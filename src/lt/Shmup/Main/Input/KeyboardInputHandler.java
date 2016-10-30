package lt.Shmup.Main.Input;

import lt.Shmup.Main.Command.Command;

import java.awt.event.KeyListener;

public interface KeyboardInputHandler extends KeyListener {
    void addKeyPressedCommand(int key, Command command);
    void addKeyReleasedCommand(int key, Command command);
    KeyState getKeyStateContainer();
}
