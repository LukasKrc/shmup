package lt.shmup.main.game.gameobject.collision.handlers;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.collision.CollisionHandler;

public class HealthCollision implements CollisionHandler {

    private ObjectHandler objectHandler;

    public HealthCollision(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void update(GameObject gameObject) {
        for (
            GameObject newGameObject : this.objectHandler.getGameObjects()
        ) {
            if (!this.shouldColide(gameObject, newGameObject)) {
                continue;
            }
            if (
                gameObject.getBounds().intersects(newGameObject.getBounds())
            ) {
                this.handleGameObjectCollision(gameObject, newGameObject);
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
        if (gameObject.getIdentifier() == Identifier.PlayerProjectile) {
            objectHandler.removeObject(gameObject);
            otherGameObject.setHealth(otherGameObject.getHealth() - 50);
        } else {
            gameObject.setHealth(gameObject.getHealth() - 50);
        }
    }

    private boolean shouldColide(
            GameObject firstGameObject,
            GameObject secondGameObject
    ) {
        if (firstGameObject == secondGameObject) {
            return false;
        }
        if (firstGameObject.getIdentifier() == Identifier.Player
            && secondGameObject.getIdentifier() == Identifier.PlayerProjectile)
        {
            return false;
        }

        return true;
    }
}
