package lt.Shmup.Main.Command.CommandDispatchers;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.CommandStore;

public interface KeyboardCommandDispatcher {
    void dispatchCommand(int key);
    CommandStore<Command> getCommandStore();
}
