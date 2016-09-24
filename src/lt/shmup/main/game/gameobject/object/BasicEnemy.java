package lt.shmup.main.game.gameobject.object;

import lt.shmup.main.Game;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;

import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(int x, int y, Identifier identifier) {
        super(x, y, identifier);

        this.setVelocityY(5);
        this.setVelocityX(5);
    }

    @Override
    public void update() {
        this.setX(this.getX() + this.getVelocityX());
        this.setY(this.getY() + this.getVelocityY());

        int y = this.getY();
        int x = this.getX();
        if (y <= 0 || y >= Game.WINDOW_HEIGHT) {
            this.setVelocityY(-this.getVelocityY());
        }
        if (x <= 0 || x >= Game.WINDOW_WIDTH) {
            this.setVelocityX(-this.getVelocityX());
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 16, 16);
    }
}
