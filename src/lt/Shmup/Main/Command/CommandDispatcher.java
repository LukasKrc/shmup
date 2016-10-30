package lt.Shmup.Main.Command;

public abstract class CommandDispatcher<CommandType> {
    private CommandStore<CommandType> commands;

    public CommandDispatcher(CommandStore<CommandType> commands) {
        this.commands = commands;
    }

    public CommandStore<CommandType> getCommandStore() {
        return commands;
    }
}
