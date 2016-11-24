package lt.Shmup.Main.GameObject.Factories.Entity.ProjectileFactorys;

import lt.Shmup.Config;
import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.DeathHealth;
import lt.Shmup.Main.GameObject.Factories.Entity.ProjectileFactory;
import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactory;
import lt.Shmup.Main.GameObject.Factories.RenderableFactory;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.DamageTakenObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.Graphics.ImageWrapper;


public class DefaultProjectileFactory implements ProjectileFactory {
    private RenderableFactory renderableFactory;
    private ImageWrapper playerProjectileImageWrapper;
    private ImageWrapper enemyProjectileImageWrapper;
    private int playerProjectileDamage;
    private int enemyProjectileDamage;
    private DamageCausingEntity projectile;

    public DefaultProjectileFactory(
        RenderableFactory renderableFactory,
        ImageWrapperFactory imageWrapperFactory,
        EntityBuilder entityBuilder
    ) {
        this.renderableFactory = renderableFactory;
        int layerIndex =
                Config.intg("game/z-indexes/projectiles");
        playerProjectileDamage =
                Config.intg("game/values/damage/projectile/player");
        enemyProjectileDamage =
                Config.intg("game/values/damage/projectile/enemy");
        int projectileWidth =
                Config.intg("game/dimensions/projectiles/basic/width");
        int projectileHeight =
                Config.intg("game/dimensions/projectiles/basic/height");
        String playerProjectileImagePath =
                Config.str("graphics/images/projectiles/basic_player/path");
        String enemyProjectileImagePath =
                Config.str("graphics/images/projectiles/basic_enemy/path");
        playerProjectileImageWrapper =
                imageWrapperFactory.getDefaultImageWrapper(
                        playerProjectileImagePath,
                        projectileWidth,
                        projectileHeight
                );
        enemyProjectileImageWrapper =
                imageWrapperFactory.getDefaultImageWrapper(
                        enemyProjectileImagePath,
                        projectileWidth,
                        projectileHeight
                );
        Health projectileHealth = new DeathHealth(0, 1, 1);
        projectile = entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setLayerIndex(layerIndex)
                .setVolume(new BasicVolume(projectileWidth, projectileHeight))
                .setHealth(projectileHealth)
                .getDamageCausingEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public DamageCausingEntity getProjectile(Identifier identifier) {
        switch (identifier) {
            case Player:
                setProjectileFields(
                        playerProjectileImageWrapper,
                        playerProjectileDamage,
                        Identifier.PlayerProjectile
                );
                break;
            case Enemy:
                setProjectileFields(
                        enemyProjectileImageWrapper,
                        enemyProjectileDamage,
                        Identifier.EnemyProjectile
                );
                break;
            default:
                throw new RuntimeException(
                        "Projectile of type " + String.valueOf(identifier) + " does not exist."
                );
        }

        DamageCausingEntity newProjectile = projectile.clone();
        newProjectile.attachObserver(new DamageTakenObserver());
        return newProjectile;
    }

    private void setProjectileFields(
            ImageWrapper imageWrapper,
            int damage,
            Identifier identifier
    ) {
        projectile.setRenderable(renderableFactory.createImageGraphics(
                imageWrapper
        ));
        projectile.setCollisionDamage(damage);
        projectile.setIdentifier(identifier);
        projectile.setHealth(new DeathHealth(0, 1, 1));
    }
}
