package test.lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers; 

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lt.Shmup.Main.Command.Command;
import lt.Shmup.Main.Command.CommandDispatchers.KeyboardCommandDispatchers.DefaultKeyboardCommandDispatcher;
import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers.DefaultMouseCommandDispatcher;
import lt.Shmup.Main.Command.CommandStore;
import lt.Shmup.Main.MouseCommand;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import test.lt.Shmup.Main.Command.CommandDispatchers.CommandDispatcherTest;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.LinkedList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** 
* DefaultMouseCommandDispatcher Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 26, 2016</pre> 
* @version 1.0 
*/

@RunWith(DataProviderRunner.class)
public class DefaultMouseCommandDispatcherTest extends
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
        MouseCommand command = mock(MouseCommand.class);
        CommandStore<MouseCommand> commandStore = mock(CommandStore.class);
        when(commandStore.getCommand(key))
                .thenReturn(new LinkedList<MouseCommand>(Arrays.asList(command)));
        commandStore.addCommand(key, command);
        DefaultMouseCommandDispatcher dispatcher =
                new DefaultMouseCommandDispatcher(commandStore);
        MouseEvent mouseEvent = mock(MouseEvent.class);
        dispatcher.dispatchCommand(key, mouseEvent);
        verify(command).execute(mouseEvent);
        verify(commandStore).getCommand(key);
    }
} 
