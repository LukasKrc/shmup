package lt.shmup.main.game.commands;

import lt.shmup.main.game.Command;

public interface CommandDispatcher<KeyType> {
    void dispatchCommand(KeyType key);
    void addCommand(KeyType key, Command command);
    void removeCommand(KeyType key, Command command);
}
