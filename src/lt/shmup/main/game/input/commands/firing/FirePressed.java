package lt.shmup.main.game.input.commands;

import lt.shmup.main.game.Command;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.collision.handlers.HealthCollision;
import lt.shmup.main.game.gameobject.graphics.handlers.GameObjectGraphics;
import lt.shmup.main.game.gameobject.graphics.handlers.ImageGraphics;
import lt.shmup.main.game.gameobject.movement.handlers.EnemyMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.OutOfBoundsDecorator;
import lt.shmup.main.game.gameobject.object.Player;
import lt.shmup.main.game.gameobject.object.Projectile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class FirePressed implements Command {

    private ObjectHandler objectHandler;

    private GameObject gameObject;

    private boolean keyIsPressed;

    public FirePressed(ObjectHandler objectHandler, GameObject gameObject) {
        this.objectHandler = objectHandler;
        this.gameObject = gameObject;
    }

    @Override
    public void execute() {
        if (this.keyIsPressed) {
            return;
        }
        this.spawnPlayerProjectile();
        this.setKeyIsPressed(true);
    }

    public void setKeyIsPressed(boolean isPressed) {
        this.keyIsPressed = isPressed;
    }

    private void spawnPlayerProjectile() {
        GameObject projectile = new Projectile(
                this.gameObject.getX() + 16,
                this.gameObject.getY() + -16,
                10,
                10,
                Identifier.PlayerProjectile,
                new ImageGraphics("images/laserRed.png", 4, 8),
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
