package lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers;

import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatcher;
import lt.Shmup.Main.MouseCommand;
import lt.Shmup.Main.Command.CommandDispatcher;
import lt.Shmup.Main.Command.CommandStore;

import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class DefaultMouseCommandDispatcher extends CommandDispatcher<MouseCommand> implements MouseCommandDispatcher {
    public DefaultMouseCommandDispatcher(CommandStore<MouseCommand> commands) {
        super(commands);
    }

    @Override
    public void dispatchCommand(int key, MouseEvent event) {
        LinkedList<MouseCommand> commands = this.getCommandStore().getCommand(key);
        for (MouseCommand command : commands) {
            command.execute(event);
        }
    }
}
