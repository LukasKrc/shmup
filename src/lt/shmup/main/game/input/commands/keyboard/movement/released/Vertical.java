//package lt.shmup.main.game.input.commands.movement.released;
//
//import lt.shmup.main.game.Command;
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.input.KeyStateHandler;
//
//public class Vertical implements Command {
//
//    private GameObject gameObject;
//
//    private KeyStateHandler keyStateHandler;
//
//    private int oppositeKeyCode;
//
//    private Command oppositeKeyCommand;
//
//    public Vertical(
//        GameObject gameObject,
//        KeyStateHandler keyStateHandler,
//        int oppositeKeyCode,
//        Command oppositeKeyCommand
//    ) {
//        this.gameObject = gameObject;
//        this.keyStateHandler = keyStateHandler;
//        this.oppositeKeyCode = oppositeKeyCode;
//        this.oppositeKeyCommand = oppositeKeyCommand;
//    }
//
//    @Override
//    public void execute() {
//        if (this.keyStateHandler.isKeyPressed(oppositeKeyCode)) {
//            this.oppositeKeyCommand.execute();
//            return;
//        }
//        this.gameObject.setVelocityY(0);
//    }
//}
