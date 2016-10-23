package lt.shmup.main.game.input;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.commands.CommandDispatcher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputHandler implements MouseListener {

    public static final int CLICKED_EVENT = 0;
    public static final int PRESSED_EVENT = 1;
    public static final int RELEASED_EVENT = 3;
    public static final int ENTERED_EVENT = 4;
    public static final int EXITED_EVENT = 5;

    private CommandDispatcher<Integer> commandDispatcher;

    public MouseInputHandler(CommandDispatcher<Integer> commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    public void addCommand(int key, Command command) {
        this.commandDispatcher.addCommand(key, command);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.commandDispatcher.dispatchCommand(MouseInputHandler.CLICKED_EVENT);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.commandDispatcher.dispatchCommand(MouseInputHandler.PRESSED_EVENT);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.commandDispatcher.dispatchCommand(MouseInputHandler.RELEASED_EVENT);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.commandDispatcher.dispatchCommand(MouseInputHandler.ENTERED_EVENT);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.commandDispatcher.dispatchCommand(MouseInputHandler.EXITED_EVENT);
    }
}
