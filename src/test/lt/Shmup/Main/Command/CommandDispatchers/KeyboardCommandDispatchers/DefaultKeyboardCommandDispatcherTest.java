package test.lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatchers;

import static org.mockito.Mockito.*;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatchers.DefaultKeyboardCommandDispatcher;
import lt.Shmup.Main.Command.CommandStore;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import test.lt.Shmup.Main.Command.CommandDispatchers.CommandDispatcherTest;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 
* DefaultKeyboardCommandDispatcher Tester. 
* 
* @author <Authors name>
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/

@RunWith(DataProviderRunner.class)
public class DefaultKeyboardCommandDispatcherTest extends
        CommandDispatcherTest
{
    /**
    *
    * Method: dispatchCommand(int key)
    *
    */
    @Test
    @UseDataProvider("provideCommandKeys")
    public void commandsGetDispatched(int key) throws Exception {
        Command command = mock(Command.class);
        CommandStore<Command> commandStore = mock(CommandStore.class);
        when(commandStore.getCommand(key))
                .thenReturn(new LinkedList<Command>(Arrays.asList(command)));
        commandStore.addCommand(key, command);
        DefaultKeyboardCommandDispatcher dispatcher =
                new DefaultKeyboardCommandDispatcher(commandStore);
        dispatcher.dispatchCommand(key);
        verify(command).execute();
        verify(commandStore).getCommand(key);
    }
}
