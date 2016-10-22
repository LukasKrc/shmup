package lt.shmup.main.game.commands.dispatcher;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.commands.CommandDispatcher;

import java.util.HashMap;
import java.util.LinkedList;

public class HashMapDispatcher implements CommandDispatcher<Integer> {

    private HashMap<Integer, LinkedList<Command>> commands = new HashMap();

    @Override
    public void dispatchCommand(Integer key) {
        LinkedList<Command> commands = this.commands.getOrDefault(key, new LinkedList<>());
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void addCommand(Integer key, Command command) {
        this.commands.putIfAbsent(key, new LinkedList<>());
        this.commands.get(key).add(command);
    }

    @Override
    public void removeCommand(Integer key, Command command) {
        LinkedList<Command> commands = this.commands.get(key);
        if (commands == null) {
            return;
        }
        commands.remove(command);
    }

}
