package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.ObjectHandler;
import lt.shmup.main.game.userinterface.HeadsUpDisplay;

import java.awt.*;

public class Player extends GameObject {

    private ObjectHandler objectHandler;

    public Player(
            int x,
            int y,
            Identifier identifier,
            ObjectHandler objectHandler
    ) {
        super(x, y, identifier);
        this.objectHandler = objectHandler;
    }

    @Override
    public void update() {
        this.setX(this.getX() + this.getVelocityX());
        this.setY(this.getY() + this.getVelocityY());

        this.setX(Game.clamp(this.getX(), 0, Game.WINDOW_WIDTH));
        this.setY(Game.clamp(this.getY(), 0, Game.WINDOW_HEIGHT));
        this.handleCollission();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(this.getX(), this.getY(), 32, 32);
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
