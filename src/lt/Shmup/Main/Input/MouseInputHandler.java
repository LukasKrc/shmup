package lt.Shmup.Main.Input;

import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatcher;
import lt.Shmup.Main.Command.CommandDispatchers.MouseCommandDispatchers.DefaultMouseCommandDispatcher;
import lt.Shmup.Main.MouseCommand;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface MouseInputHandler extends MouseListener, MouseMotionListener {
    int CLICKED_EVENT = 0;
    int PRESSED_EVENT = 1;
    int RELEASED_EVENT = 2;
    int ENTERED_EVENT = 3;
    int EXITED_EVENT = 4;
    int DRAGGED_EVENT = 5;
    int MOVED_EVENT = 6;

    void addCommand(int key, MouseCommand mouseCommand);
}
