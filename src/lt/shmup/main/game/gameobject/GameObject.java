package lt.shmup.main.game.gameobject;

import lt.shmup.main.game.gameobject.graphics.GraphicsHandler;
import lt.shmup.main.game.gameobject.transform.TransformHandler;

import java.awt.*;

public abstract class GameObject {

    /**
     * Game object type identifier.
     */
    private Identifier identifier;

    /**
     * Game object position handler.
     */
    private TransformHandler transformHandler;

    public GameObject(
        Identifier identifier,
        GraphicsHandler graphicsHandler,
        TransformHandler transformHandler
    ) {
        this.identifier = identifier;
        this.transformHandler = transformHandler;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public TransformHandler getTransformHandler() {
        return transformHandler;
    }

}
