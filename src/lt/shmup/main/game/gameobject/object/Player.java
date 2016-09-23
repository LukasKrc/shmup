package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, Identifier identifier) {
        super(x, y, identifier);

    }

    @Override
    public void update() {
        this.setX(this.getX() + this.getVelocityX());
        this.setY(this.getY() + this.getVelocityY());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(this.getX(), this.getY(), 32, 32);
    }
}
