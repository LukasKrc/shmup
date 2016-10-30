package lt.Shmup.Main.GameObject.Visitors;

import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderer;
import lt.Shmup.Main.GameObject.Components.Updateables.Collision.HealthCollision;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Visitor;

import java.awt.*;

public class DefaultVisitor implements Visitor {
    private HealthCollision healthCollision;
    private TextRenderer textRenderer;

    public DefaultVisitor(
            HealthCollision healthCollision,
            TextRenderer textRenderer
    ) {
        this.healthCollision = healthCollision;
        this.textRenderer = textRenderer;
    }

    @Override
    public void visitRendering(Graphics2D graphics, Entity entity) {
        entity.getRenderable().render(graphics, entity);
    }

    @Override
    public void visitRendering(Graphics2D graphics, TextEntity text) {
        textRenderer.render(graphics, text);
    }

    @Override
    public void visitRendering(Graphics2D graphics, ButtonEntity button) {
        button.setColor(button.getButtonStateColors().get(button.getState()));
        textRenderer.render(graphics, button);
    }

    @Override
    public void visitUpdating(Entity entity) {
        entity.getBehaviour().update(entity);
        entity.getMovement().update(entity);
        entity.getHealth().update(entity);
    }

    @Override
    public void visitUpdating(DamageCausingEntity entity) {
        visitUpdating((Entity) entity);
        healthCollision.update(entity);
    }
}
