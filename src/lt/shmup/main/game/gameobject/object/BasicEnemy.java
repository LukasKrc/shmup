package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.collision.CollisionHandler;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;

import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(
            int x,
            int y,
            int health,
            int maxHealth,
            Identifier identifier,
            GraphicsHandler graphicsHandler,
            MovementHandler movementHandler,
            CollisionHandler collisionHandler
    ) {
        super(
            x,
            y,
            health,
            maxHealth,
            identifier,
            graphicsHandler,
            movementHandler,
            collisionHandler
        );

        this.setVelocityY(5);
        this.setVelocityX(5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 16, 16);
    }
}
