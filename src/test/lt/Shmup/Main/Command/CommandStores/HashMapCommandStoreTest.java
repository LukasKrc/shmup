package test.lt.Shmup.Main.Command.CommandStores; 

import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.CommandStores.HashMapCommandStore;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.mock;

/** 
* HashMapCommandStore Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/ 
public class HashMapCommandStoreTest { 
    @Test
    public void returnsAddedCommand() throws Exception {
        int key = 0;
        HashMapCommandStore<Command> commandStore = new HashMapCommandStore<>();
        Command command = mock(Command.class);
        commandStore.addCommand(key, command);
        LinkedList<Command> receivedCommands = commandStore.getCommand(key);
        assertSame(command, receivedCommands.get(0));
    }

    @Test
    public void returnsEmptyListIfNoCommandsAdded() throws Exception {
        HashMapCommandStore<Command> commandStore = new HashMapCommandStore<>();
        LinkedList<Command> commands = commandStore.getCommand(0);
        assertEquals(commands, new LinkedList<Command>());
    }
} 
