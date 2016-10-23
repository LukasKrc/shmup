//package lt.shmup.main.game.gameobject.object.entity;
//
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.gameobject.Identifier;
//import lt.shmup.main.game.gameobject.behaviour.BehaviourHandler;
//import lt.shmup.main.game.gameobject.collision.CollisionHandler;
//import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
//import lt.shmup.main.game.gameobject.health.HealthHandler;
//import lt.shmup.main.game.gameobject.movement.MovementHandler;
//
//import java.awt.*;
//
//public class BasicEnemy extends GameObject{
//
//    private BehaviourHandler behaviourHandler;
//
//    public BasicEnemy(
//        int x,
//        int y,
//        int health,
//        int maxHealth,
//        Identifier identifier,
//        GraphicsHandler graphicsHandler,
//        MovementHandler movementHandler,
//        CollisionHandler collisionHandler,
//        BehaviourHandler behaviourHandler,
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
//
//        this.behaviourHandler = behaviourHandler;
//        this.setVelocityX(5);
//    }
//
//    @Override
//    public void update() {
//        super.update();
//        if (this.behaviourHandler != null) {
//            behaviourHandler.update(this);
//        }
//    }
//
//    @Override
//    public Rectangle getBounds() {
//        return new Rectangle(this.getX(), this.getY(), 16, 16);
//    }
//}
