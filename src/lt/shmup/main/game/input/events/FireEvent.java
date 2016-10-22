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
import java.util.HashMap;

public class FireEvent extends InputEvent {

    private ObjectHandler objectHandler;

    public FireEvent(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    public void handleKeyPressedEvent(KeyEvent keyEvent, HashMap<Integer, Boolean> keyStates) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            this.spawnPlayerProjectile(this.getGameObject());
        }
    }

    public void handleKeyReleasedEvent(KeyEvent keyEvent, HashMap<Integer, Boolean> keyStates) {
        // Do nothing
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
