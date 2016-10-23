//package lt.shmup.main.game.gameobject.movement.handlers.decorators;
//
//import lt.shmup.main.Utility;
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.gameobject.movement.MovementHandler;
//import lt.shmup.main.game.gameobject.movement.handlers.MovementDecorator;
//
//public class ClampDecorator extends MovementDecorator {
//
//    public ClampDecorator(MovementHandler movementHandler) {
//        super(movementHandler);
//    }
//
//    @Override
//    public void update(GameObject gameObject) {
//        this.getMovementHandler().update(gameObject);
//        gameObject.setX(
//                Utility.clampInt(gameObject.getX(), 0, Utility.WINDOW_WIDTH)
//        );
//        gameObject.setY(
//                Utility.clampInt(gameObject.getY(), 0, Utility.WINDOW_HEIGHT)
//        );
//    }
//
//}
