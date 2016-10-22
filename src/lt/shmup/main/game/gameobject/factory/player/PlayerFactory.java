package lt.shmup.main.game.gameobject.factory.player;

import lt.shmup.main.Utility;
import lt.shmup.main.game.gameobject.GameObject;
import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.factory.CollisionFactory;
import lt.shmup.main.game.gameobject.factory.GameObjectFactory;
import lt.shmup.main.game.gameobject.graphics.handlers.ImageGraphics;
import lt.shmup.main.game.gameobject.health.handler.DefaultHealth;
import lt.shmup.main.game.gameobject.movement.handlers.PlayerMovement;
import lt.shmup.main.game.gameobject.movement.handlers.decorators.ClampDecorator;
import lt.shmup.main.game.gameobject.object.entity.Player;

public class PlayerFactory implements GameObjectFactory{

    private CollisionFactory collisionFactory;

    public PlayerFactory(CollisionFactory collisionFactory) {
        this.collisionFactory = collisionFactory;
    }

    @Override
    public GameObject getCharacter(String type) {
        return new Player(
                Utility.WINDOW_WIDTH/2 - 32,
                Utility.WINDOW_HEIGHT/2 - 32,
                100,
                100,
                Identifier.Player,
                new ImageGraphics("images/player.png", 32, 32),
                new ClampDecorator(new PlayerMovement()),
                collisionFactory.getCollisionHandler("health"),
                new DefaultHealth(0, 100, 100)
        );
    }

    @Override
    public GameObject getProjectile(String type) {
        return null;
    }
}
