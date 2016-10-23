//package lt.shmup.main.game.gameobject.factory;
//
//import lt.shmup.main.game.gameobject.ObjectHandler;
//import lt.shmup.main.game.gameobject.behaviour.BehaviourHandler;
//import lt.shmup.main.game.gameobject.collision.CollisionHandler;
//import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
//
//public class CollisionFactory {
//    private ObjectHandler gameObjectHandler;
//
//    public CollisionFactory(ObjectHandler gameObjectHandler) {
//        this.gameObjectHandler = gameObjectHandler;
//    }
//
//    public CollisionHandler getCollisionHandler(String type) {
//        switch (type) {
//            case "health" :
//                return new HealthCollision(this.gameObjectHandler);
//        }
//
//        throw new RuntimeException("Collision type : " + type + " is not defined.");
//    }
//}
