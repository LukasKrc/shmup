package lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatchers;

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatcher;
import lt.Shmup.Main.Command.CommandStore;
import lt.Shmup.Main.Command.CommandDispatcher;

import java.util.LinkedList;

public class DefaultKeyboardCommandDispatcher extends CommandDispatcher<Command> implements KeyboardCommandDispatcher {
    public DefaultKeyboardCommandDispatcher(CommandStore<Command> commands) {
        super(commands);
    }

    @Override
    public void dispatchCommand(int key) {
        LinkedList<Command> commands = this.getCommandStore().getCommand(key);
        for (Command command : commands) {
            command.execute();
        }
    }
}
