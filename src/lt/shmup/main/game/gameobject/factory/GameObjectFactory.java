package lt.shmup.main.game.gameobject.factory;

import lt.shmup.main.game.gameobject.GameObject;

public interface GameObjectFactory {
    GameObject getCharacter(String type);
    GameObject getProjectile(String type);
}
