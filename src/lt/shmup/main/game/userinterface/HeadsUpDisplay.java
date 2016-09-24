package lt.shmup.main.game.userinterface;

import lt.shmup.main.Game;
import lt.shmup.main.Utility;

import java.awt.*;

public class HeadsUpDisplay {

    public static int PLAYER_HEALTH = 100;

    public void update() {
        this.PLAYER_HEALTH = Utility.clamp(this.PLAYER_HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, this.PLAYER_HEALTH * 2, 32);
        g.setColor(Color.gray);
        g.drawRect(15, 15, 200, 32);
    }
}
