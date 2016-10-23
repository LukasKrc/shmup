//package lt.shmup.main.game.gameobject.factory;
//
//import lt.shmup.main.game.gameobject.ObjectHandler;
//import lt.shmup.main.game.gameobject.factory.enemy.EnemyFactory;
//import lt.shmup.main.game.gameobject.factory.player.PlayerFactory;
//
//public class FactoryFactory {
//
//    private CollisionFactory collisionFactory;
//
//    private BehaviourFactory behaviourFactory;
//
//    public FactoryFactory(ObjectHandler gameObjectHandler) {
//        this.collisionFactory = new CollisionFactory(gameObjectHandler);
//        this.behaviourFactory = new BehaviourFactory(gameObjectHandler);
//    }
//
//    public GameObjectFactory getFactory(String type) {
//        switch (type) {
//            case "player":
//                return new PlayerFactory(collisionFactory);
//            case "enemy":
//                return new EnemyFactory(collisionFactory, behaviourFactory);
//        }
//
//        throw new RuntimeException("Factory type: " + type + " is not defined");
//    }
//}
