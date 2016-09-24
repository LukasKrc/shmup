package lt.shmup.main.game.gameobject.collision.handlers;

import lt.shmup.main.game.gameobject.GameObject;
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
            if (newGameObject == gameObject) {
                continue;
            }
            if (
                gameObject.getBounds().intersects(newGameObject.getBounds())
            ) {
                gameObject.setHealth(gameObject.getHealth() - 1);
                System.out.println(gameObject.getHealth());
            }
        }
    }

}
