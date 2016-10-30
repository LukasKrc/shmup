package lt.Shmup.Main.Command.CommandStores;

import lt.Shmup.Main.Command.CommandStore;

import java.util.HashMap;
import java.util.LinkedList;

public class HashMapCommandStore<CommandType> implements CommandStore<CommandType> {
    private HashMap<Integer, LinkedList<CommandType>> commands = new HashMap();

    @Override
    public void addCommand(int key, CommandType command) {
        commands.putIfAbsent(key, new LinkedList<>());
        commands.get(key).add(command);
    }

    @Override
    public LinkedList<CommandType> getCommand(int key) {
        return commands.getOrDefault(key, new LinkedList<CommandType>());
    }
}
