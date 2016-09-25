package lt.shmup.main.game.gameobject.behaviour.handlers;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.behaviour.BehaviourHandler;
import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
import lt.shmup.main.game.gameobject.graphics.handlers.GameEntity;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.object.Projectile;

import java.awt.*;
import java.util.Random;

public class BasicEnemyBehaviour implements BehaviourHandler {

    private ObjectHandler objectHandler;
    private Random randomGenerator = new Random();
    private int lastMovementChangeTime = 0;

    public BasicEnemyBehaviour(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void update(GameObject gameObject) {
        boolean directionChanged =
            this.changeMovementDirectionIfNeeded(gameObject);
        if (!directionChanged) {
            return;
        }

        this.fireProjectile(gameObject);
    }

    private boolean changeMovementDirectionIfNeeded(GameObject gameObject) {
        boolean decision = this.randomGenerator.nextBoolean();
        int currentTimeInSeconds = (int) (System.currentTimeMillis()/ 1000);
        int movementTimeDelta =
                currentTimeInSeconds - this.lastMovementChangeTime;
        if (decision && movementTimeDelta > 1) {
            gameObject.setVelocityX(-gameObject.getVelocityX());
            this.lastMovementChangeTime = currentTimeInSeconds;

            return true;
        }

        return false;
    }

    private void fireProjectile(GameObject gameObject) {
        GameObject projectile = new Projectile(
            gameObject.getX() + 8,
            gameObject.getY() + 16,
            10,
            10,
            Identifier.EnemyProjectile,
            new GameEntity(2, 4, Color.red),
            new EnemyMovement(),
            new HealthCollision(this.objectHandler)
        );

        projectile.setVelocityY(10);

        this.objectHandler.addObject(projectile);
    }

}
