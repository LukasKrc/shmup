package lt.Shmup.Main.Command;

import java.util.LinkedList;

public interface CommandStore<CommandType> {
    void addCommand(int key, CommandType command);
    LinkedList<CommandType> getCommand(int key);
}
