package lt.Shmup.Main.Command.CommandDispatchers;

import lt.Shmup.Main.Command.CommandStore;
import lt.Shmup.Main.MouseCommand;

import java.awt.event.MouseEvent;

public interface MouseCommandDispatcher {
    void dispatchCommand(int key, MouseEvent event);
    CommandStore<MouseCommand> getCommandStore();
}
