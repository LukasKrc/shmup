package lt.shmup.main.game.gameobject.movement.handlers;

import lt.shmup.main.Utility;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.movement.MovementHandler;

public class EnemyMovement extends MovementHandler{

    @Override
    public void update(GameObject gameObject) {
        gameObject.setX(gameObject.getX() + gameObject.getVelocityX());
        gameObject.setY(gameObject.getY() + gameObject.getVelocityY());
    }

}
