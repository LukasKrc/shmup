package lt.shmup.main.game.gameobject.factory.enemy;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.factory.BehaviourFactory;
import lt.shmup.main.game.gameobject.factory.CollisionFactory;
import lt.shmup.main.game.gameobject.factory.GameObjectFactory;
import lt.shmup.main.game.gameobject.graphics.handlers.ImageGraphics;
import lt.shmup.main.game.gameobject.health.handler.DefaultHealth;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ReflectDecorator;
import lt.shmup.main.game.gameobject.object.entity.BasicEnemy;

public class EnemyFactory implements GameObjectFactory{

    private CollisionFactory collisionFactory;

    private BehaviourFactory behaviourFactory;

    public EnemyFactory(CollisionFactory collisionFactory, BehaviourFactory behaviourFactory) {
        this.collisionFactory = collisionFactory;
        this.behaviourFactory = behaviourFactory;
    }

    @Override
    public GameObject getCharacter(String type) {
        return new BasicEnemy(
            70,
            70,
            100,
            100,
            Identifier.Enemy,
            new ImageGraphics("images/enemyShip.png", 32, 32),
            new ReflectDecorator(new EnemyMovement()),
            collisionFactory.getCollisionHandler("health"),
            behaviourFactory.getBehaviourHandler("basicEnemy"),
            new DefaultHealth(0, 50, 50)
        );
    }

    @Override
    public GameObject getProjectile(String type) {
        return null;
    }
}
