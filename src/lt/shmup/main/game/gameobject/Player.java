package lt.shmup.main.game.gameobject;

import lt.shmup.main.game.GameObject;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, Identifier identifier) {
        super(x, y, identifier);

        setX(100);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(this.getX(), this.getY(), 32, 32);
    }
}
