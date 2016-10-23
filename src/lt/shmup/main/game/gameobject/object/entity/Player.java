//package lt.shmup.main.game.gameobject.object.entity;
//
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.gameobject.Identifier;
//import lt.shmup.main.game.gameobject.ObjectHandler;
//import lt.shmup.main.game.gameobject.collision.CollisionHandler;
//import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
//import lt.shmup.main.game.gameobject.health.HealthHandler;
//import lt.shmup.main.game.gameobject.movement.MovementHandler;
//
//import java.awt.*;
//
//public class Player extends GameObject {
//
//    public Player(
//        int x,
//        int y,
//        int health,
//        int maxHealth,
//        Identifier identifier,
//        GraphicsHandler graphicsHandler,
//        MovementHandler movementHandler,
//        CollisionHandler collisionHandler,
//        HealthHandler healthHandler
//    ) {
//        super(
//            x,
//            y,
//            health,
//            maxHealth,
//            identifier,
//            graphicsHandler,
//            movementHandler,
//            collisionHandler,
//            healthHandler
//        );
//    }
//
//    @Override
//    public Rectangle getBounds() {
//        return new Rectangle(this.getX(), this.getY(), 32, 32);
//    }
//}
