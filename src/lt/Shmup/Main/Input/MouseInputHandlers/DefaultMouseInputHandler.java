package lt.Shmup.Main.Input.MouseInputHandlers;

import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatcher;
import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers.DefaultMouseCommandDispatcher;
import lt.Shmup.Main.MouseCommand;

import java.awt.event.MouseEvent;

public class DefaultMouseInputHandler implements lt.Shmup.Main.Input.MouseInputHandler {
    private MouseCommandDispatcher mouseCommandDispatcher;

    public DefaultMouseInputHandler(MouseCommandDispatcher mouseCommandDispatcher) {
        this.mouseCommandDispatcher = mouseCommandDispatcher;
    }

    @Override
    public void addCommand(int key, MouseCommand mouseCommand) {
        mouseCommandDispatcher.getCommandStore().addCommand(key, mouseCommand);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.CLICKED_EVENT, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.PRESSED_EVENT, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.RELEASED_EVENT, e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.ENTERED_EVENT, e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.EXITED_EVENT, e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.DRAGGED_EVENT, e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mouseCommandDispatcher.dispatchCommand(lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler.MOVED_EVENT, e);
    }
}
