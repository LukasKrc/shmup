package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.movement.MovementHandler;
import lt.shmup.main.game.gameobject.movement.handlers.PlayerMovement;
import lt.shmup.main.game.userinterface.HeadsUpDisplay;

import java.awt.*;

public class Player extends GameObject {

    private ObjectHandler objectHandler;

    public Player(
            int x,
            int y,
            Identifier identifier,
            ObjectHandler objectHandler,
            GraphicsHandler graphicsHandler,
            MovementHandler movementHandler
    ) {
        super(x, y, identifier, graphicsHandler, movementHandler);
        this.objectHandler = objectHandler;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 32, 32);
    }

    private void handleCollission() {
        for (GameObject gameObject : objectHandler.getGameObjects()) {
            if (gameObject.getIdentifier() == Identifier.Enemy) {
                if (this.getBounds().intersects(gameObject.getBounds())) {
                    HeadsUpDisplay.PLAYER_HEALTH -= 2;
                }
            }
        }
    }
}
