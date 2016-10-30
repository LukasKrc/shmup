package lt.Shmup.Main.GameObject.Components.Renderables;

import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.awt.*;

public class HealthBarGraphics implements EntityAwareRenderable {
    private Entity trackedEntity;
    private Color healthColor = new Color(10, 200, 10);
    private Color borderColor = Color.WHITE;

    public HealthBarGraphics(Entity entity) {
        trackedEntity = entity;
    }

    @Override
    public void render(Graphics2D graphics, Entity entity) {
        Position position = entity.getPosition();
        Volume volume = entity.getVolume();
        Health trackedHealth = trackedEntity.getHealth();
        float healthPercentage =
                (float) trackedHealth.getHealth() / (float) trackedHealth.getMaximumHealth();
        graphics.setColor(borderColor);
        fillRectangle(graphics, volume, position);
        graphics.setColor(healthColor);
        drawRectangle(graphics, volume, position, healthPercentage);
    }

    @Override
    public EntityAwareRenderable clone() {
        return new HealthBarGraphics(trackedEntity);
    }

    private void fillRectangle(
            Graphics2D graphics,
            Volume volume,
            Position position
    ) {
        graphics.drawRect(
                (int) position.getX(),
                (int) position.getY(),
                (int) volume.getWidth(),
                (int) volume.getHeight()
        );
    }

    private void drawRectangle(
            Graphics2D graphics,
            Volume volume,
            Position position,
            float healthPercentage
    ){
        graphics.fillRect(
                (int) position.getX(),
                (int) position.getY(),
                (int) (volume.getWidth() * healthPercentage),
                (int) volume.getHeight()
        );
    }
}
