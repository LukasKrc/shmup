package lt.Shmup.Main.GameObject.Objects.Components.EntityObservers;

import lt.Shmup.Container;
import lt.Shmup.Main.GameObject.Components.State.Position;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volume;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.LinearMovement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.RemovalDecorator;
import lt.Shmup.Main.GameObject.Factories.Entity.ProjectileFactory;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;

import java.util.HashMap;

public class ProjectileSpawnObserver implements EntityObserver {
    private ProjectileFactory projectileFactory;
    private OutOfBoundsChecker outOfBoundsChecker;

    public ProjectileSpawnObserver() {
        this.projectileFactory =
                (ProjectileFactory) Container.get(ProjectileFactory.class);
        this.outOfBoundsChecker =
                (OutOfBoundsChecker) Container.get(OutOfBoundsChecker.class);
    }

    @Override
    public void notify(Entity entity, String eventName, HashMap<String, String> data) {
        if (eventName.equals("projectile_fired")) {
            Entity projectile = getProjectile(entity);
            entity.getObjectHandler().addEntity(projectile);
        }
    }

    @Override
    public EntityObserver clone() {
        return new ProjectileSpawnObserver();
    }

    private Entity getProjectile(Entity entity) {
        Identifier identifier = entity.getIdentifier();
        Entity projectile = projectileFactory.getProjectile(identifier);
        switch (identifier) {
            case Player:
                projectile.setMovement(
                        getMovement(-10, entity)
                );
                break;
            case Enemy:
                projectile.setMovement(
                        getMovement(5, entity)
                );
                break;
        }
        projectile.setPosition(getPosition(entity));
        return projectile;
    }

    private Movement getMovement(
            int verticalSpeed,
            Entity entity
    ) {
        return new RemovalDecorator(
                new LinearMovement(
                        0,
                        entity.getMovement().getSpeedY() + verticalSpeed
                ),
                outOfBoundsChecker,
                entity.getObjectHandler()
        );
    }

    private Position getPosition(Entity entity) {
        Position position = entity.getPosition();
        Volume volume = entity.getVolume();
        return new BasicPosition(
                position.getX() + volume.getWidth() / 2,
                position.getY() + volume.getWidth() / 2
        );
    }
}
