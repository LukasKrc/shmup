package lt.Shmup.Main.GameObject.Factories.Entity;

import lt.Shmup.Container;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.EntityAwareUpdateable;
import lt.Shmup.Main.GameObject.Factories.RenderableFactory;
import lt.Shmup.Main.Graphics.ImageWrapper;

public abstract class EnemyFactory {
    private RenderableFactory renderableFactory;

    public EnemyFactory() {
        renderableFactory =
                (RenderableFactory) Container.get(RenderableFactory.class);
    }

    public RenderableFactory getRenderableFactory() {
        return renderableFactory;
    }

    public abstract EntityAwareUpdateable getBehaviour();
    public abstract EntityAwareRenderable getGraphics(
            ImageWrapper imageWrapper);
}
