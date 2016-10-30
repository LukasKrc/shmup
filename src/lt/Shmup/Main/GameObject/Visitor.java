package lt.Shmup.Main.GameObject;

import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public interface Visitor {
    void visitRendering(Graphics2D graphics, Entity entity);

    void visitRendering(Graphics2D graphics, TextEntity entity);

    void visitRendering(Graphics2D graphics, ButtonEntity button);

    void visitUpdating(Entity entity);

    void visitUpdating(DamageCausingEntity entity);
}
