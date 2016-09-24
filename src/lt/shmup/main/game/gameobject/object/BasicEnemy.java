package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;

import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(
            int x,
            int y,
            Identifier identifier,
            GraphicsHandler graphicsHandler,
            MovementHandler movementHandler
    ) {
        super(x, y, identifier, graphicsHandler, movementHandler);

        this.setVelocityY(5);
        this.setVelocityX(5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 16, 16);
    }
}
