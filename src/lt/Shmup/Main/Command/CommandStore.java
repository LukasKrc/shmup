package lt.Shmup.Main.Command;

import java.util.LinkedList;

/**
 * Created by lukas on 16.10.29.
 */
public interface CommandStore<CommandType> {
    void addCommand(int key, CommandType command);

    LinkedList<CommandType> getCommand(int key);
}
