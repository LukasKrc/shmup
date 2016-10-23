//package lt.shmup.main.game.gameobject.factory;
//
//import lt.shmup.main.game.gameobject.ObjectHandler;
//import lt.shmup.main.game.gameobject.behaviour.BehaviourHandler;
//import lt.shmup.main.game.gameobject.behaviour.handlers.BasicEnemyBehaviour;
//
//public class BehaviourFactory {
//
//    private ObjectHandler gameObjectHandler;
//
//    public BehaviourFactory(ObjectHandler gameObjectHandler) {
//        this.gameObjectHandler = gameObjectHandler;
//    }
//
//    public BehaviourHandler getBehaviourHandler(String type) {
//        switch (type) {
//            case "basicEnemy" :
//                return new BasicEnemyBehaviour(this.gameObjectHandler);
//        }
//
//        throw new RuntimeException("Behaviour type : " + type + " is not defined.");
//    }
//}
