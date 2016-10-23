//package lt.shmup.main.game.gameobject.movement.handlers.decorators;
//
//import lt.shmup.main.Utility;
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.gameobject.movement.MovementHandler;
//import lt.shmup.main.game.gameobject.movement.handlers.MovementDecorator;
//
//public class ReflectDecorator extends MovementDecorator {
//
//    public ReflectDecorator(MovementHandler movementHandler) {
//        super(movementHandler);
//    }
//
//    @Override
//    public void update(GameObject gameObject) {
//        this.getMovementHandler().update(gameObject);
//
//        int gameObjectX = gameObject.getX();
//        int gameObjectY = gameObject.getY();
//
//        if (gameObjectX <= 0 || gameObjectX >= Utility.WINDOW_WIDTH) {
//            gameObject.setVelocityX(-gameObject.getVelocityX());
//        }
//        if (gameObjectY <= 0 || gameObjectY >= Utility.WINDOW_HEIGHT) {
//            gameObject.setVelocityY(-gameObject.getVelocityY());
//        }
//    }
//
//}
