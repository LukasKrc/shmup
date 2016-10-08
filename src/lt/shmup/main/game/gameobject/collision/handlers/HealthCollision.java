package lt.shmup.main.game.gameobject.collision.handlers;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.collision.CollisionHandler;

import java.util.LinkedList;

public class HealthCollision implements CollisionHandler {

    private ObjectHandler objectHandler;
    private LinkedList<GameObject> alreadyCollidedObjects = new LinkedList<>();

    public HealthCollision(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void update(GameObject gameObject) {
        for (
            GameObject newGameObject : this.objectHandler.getGameObjects()
        ) {
            if (!this.shouldCollide(gameObject, newGameObject)) {
                continue;
            }
            if (
                gameObject.getBounds().intersects(newGameObject.getBounds())
            ) {
                this.handleGameObjectCollision(gameObject, newGameObject);
                this.alreadyCollidedObjects.add(gameObject);
            }

            if (gameObject.getHealth() <= 0) {
                 objectHandler.removeObject(gameObject);
            }
        }
    }

    private void handleGameObjectCollision(
            GameObject gameObject,
            GameObject otherGameObject
    ) {
        if (gameObject.getIdentifier() == Identifier.PlayerProjectile
            || gameObject.getIdentifier() == Identifier.EnemyProjectile
        ) {
            objectHandler.removeObject(gameObject);
            otherGameObject.setHealth(otherGameObject.getHealth() - 50);
        } else {
            gameObject.setHealth(gameObject.getHealth() - 50);
        }
    }

    private boolean shouldCollide(
            GameObject firstGameObject,
            GameObject secondGameObject
    ) {
        if (this.alreadyCollidedObjects.indexOf(secondGameObject) != -1) {
            return false;
        }
        if (firstGameObject == secondGameObject) {
            return false;
        }
        if (firstGameObject.getIdentifier() == Identifier.Player
            && secondGameObject.getIdentifier() == Identifier.PlayerProjectile
        ) {
            return false;
        }
        if (firstGameObject.getIdentifier() == Identifier.Enemy
            && secondGameObject.getIdentifier() == Identifier.EnemyProjectile
        ) {
            return false;
        }

        return true;
    }
}
