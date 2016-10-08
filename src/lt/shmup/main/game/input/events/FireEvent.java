package lt.shmup.main.game.input.events;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
import lt.shmup.main.game.gameobject.graphics.handlers.GameObjectGraphics;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.OutOfBoundsDecorator;
import lt.shmup.main.game.gameobject.object.Projectile;
import lt.shmup.main.game.input.InputEvent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FireEvent implements InputEvent {

    private ObjectHandler objectHandler;

    public FireEvent(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void handleKeyEvent(KeyEvent keyEvent, GameObject gameObject) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            this.spawnPlayerProjectile(gameObject);
        }
    }

    private void spawnPlayerProjectile(GameObject gameObject) {
        GameObject projectile = new Projectile(
                gameObject.getX() + 16,
                gameObject.getY() + -16,
                10,
                10,
                Identifier.PlayerProjectile,
                new GameObjectGraphics(2, 4, Color.white),
                new OutOfBoundsDecorator(
                    new EnemyMovement(),
                    this.objectHandler
                ),
                new HealthCollision(this.objectHandler)
        );
        projectile.setVelocityY(-10);
        objectHandler.addObject(projectile);
    }
}
