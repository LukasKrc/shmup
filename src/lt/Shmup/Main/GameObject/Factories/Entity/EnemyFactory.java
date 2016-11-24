package lt.Shmup.Main.GameObject.Factories.Entity;

import lt.Shmup.Container;
import lt.Shmup.Main.GameObject.Renderable;
import lt.Shmup.Main.GameObject.Updateable;
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

    public abstract Updateable getBehaviour();
    public abstract Renderable getGraphics(
            ImageWrapper imageWrapper);
}
