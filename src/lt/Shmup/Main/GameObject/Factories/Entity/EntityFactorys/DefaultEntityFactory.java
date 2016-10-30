package lt.Shmup.Main.GameObject.Factories.Entity.EntityFactorys;

import lt.Shmup.Config;
import lt.Shmup.Main.GameObject.Builders.EntityBuilder;
import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderer;
import lt.Shmup.Main.GameObject.Components.State.Positions.BasicPosition;
import lt.Shmup.Main.GameObject.Components.State.Volumes.BasicVolume;
import lt.Shmup.Main.GameObject.Components.Updateables.Behaviour.SpawnerBehaviour;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Health;
import lt.Shmup.Main.GameObject.Components.Updateables.Health.Healths.DeathHealth;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.LinearMovement;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.ClampDecorator;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.Components.OutOfBoundsChecker;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.OutOfBoundsDecorators.ReflectDecorator;
import lt.Shmup.Main.GameObject.Components.Updateables.Movement.Movements.MovementDecorators.ResetDecorator;
import lt.Shmup.Main.GameObject.EntityAwareRenderable;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EnemyFactoryFactory;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactory;
import lt.Shmup.Main.GameObject.Factories.ImageWrapperFactory;
import lt.Shmup.Main.GameObject.Factories.RenderableFactory;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonState;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.GameObject.Objects.Identifier;
import lt.Shmup.Main.Graphics.ImageWrapper;
import lt.Shmup.Utility;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class DefaultEntityFactory implements EntityFactory {
    private RenderableFactory renderableFactory;
    private EntityBuilder entityBuilder;
    private HashMap<String, Integer> integerConfigs = new HashMap<>();
    private HashMap<String, String> stringConfigs = new HashMap<>();
    private HashMap<String, Float> floatConfigs = new HashMap<>();
    private ImageWrapperFactory imageWrapperFactory;
    private Color collisionColor;
    private EnemyFactoryFactory enemyFactoryFactory;
    private EnemyFactory basicEnemyFactory;
    private EnemyFactory randomEnemyFactory;
    private OutOfBoundsChecker outOfBoundsChecker;
    private TextRenderer textRenderer;
    private HashMap<ButtonState, Color> buttonStateColors;

    public DefaultEntityFactory(
            RenderableFactory renderableFactory,
            EntityBuilder entityBuilder,
            ImageWrapperFactory imageWrapperFactory,
            EnemyFactoryFactory enemyFactoryFactory,
            OutOfBoundsChecker outOfBoundsChecker,
            TextRenderer textRenderer
    ) {
        this.renderableFactory = renderableFactory;
        this.entityBuilder = entityBuilder;
        this.imageWrapperFactory = imageWrapperFactory;
        this.enemyFactoryFactory = enemyFactoryFactory;
        this.outOfBoundsChecker = outOfBoundsChecker;
        populateConfigs();
        this.collisionColor = new Color(200, 10, 10);
        this.basicEnemyFactory = enemyFactoryFactory.getFactory("basic");
        this.randomEnemyFactory = enemyFactoryFactory.getFactory("random");
        this.textRenderer = textRenderer;
        buttonStateColors = renderableFactory.createButtonStateColors();
    }

    private void populateConfigs() {
        populateIntConfigs();
        populateStringConfigs();
        populateFloatConfigs();
    }

    private void populateFloatConfigs() {
        LinkedList<String> configPaths = getFloatConfigPaths();
        for (String configPath : configPaths) {
            floatConfigs.put(configPath, Config.flt(configPath));
        }
    }

    private LinkedList<String> getFloatConfigPaths() {
        LinkedList<String> configPaths = new LinkedList<>();
        configPaths.add("graphics/common/flash_decorator/alpha_step");
        configPaths.add("graphics/common/flash_decorator/initial_alpha");
        return configPaths;
    }

    private void populateStringConfigs() {
        LinkedList<String> configPaths = getStringConfigPaths();
        for (String configPath : configPaths) {
            stringConfigs.put(configPath, Config.str(configPath));
        }
    }

    private LinkedList<String> getStringConfigPaths() {
        LinkedList<String> configPaths = new LinkedList<>();
        configPaths.add("graphics/images/entities/player/path");
        configPaths.add("graphics/images/entities/enemy/basic/path");
        configPaths.add("graphics/images/entities/enemy/random/path");
        return configPaths;
    }

    private void populateIntConfigs() {
        LinkedList<String> configPaths = getIntConfigPaths();
        for (String configPath : configPaths) {
            integerConfigs.put(configPath, Config.intg(configPath));
        }
    }

    private LinkedList<String> getIntConfigPaths() {
        LinkedList<String> configPaths = new LinkedList<>();
        configPaths.add("game/dimensions/menu/button/width");
        configPaths.add("game/dimensions/menu/button/height");
        configPaths.add("game/dimensions/menu/button_gap");
        configPaths.add("graphics/images/menu_background/width");
        configPaths.add("graphics/images/menu_background/height");
        configPaths.add("graphics/images/entities/player/width");
        configPaths.add("graphics/images/entities/player/height");
        configPaths.add("game/values/health/player/max");
        configPaths.add("game/values/health/player/initial");
        configPaths.add("game/movements/player/horizontal");
        configPaths.add("game/movements/player/vertical");
        configPaths.add("game/values/damage/collision/player");
        configPaths.add("graphics/images/entities/enemy/basic/width");
        configPaths.add("graphics/images/entities/enemy/basic/height");
        configPaths.add("game/values/health/enemy/basic/initial");
        configPaths.add("game/values/health/enemy/basic/max");
        configPaths.add("game/values/damage/collision/enemy/basic");
        configPaths.add("graphics/images/entities/enemy/random/width");
        configPaths.add("graphics/images/entities/enemy/random/height");
        configPaths.add("game/values/health/enemy/random/initial");
        configPaths.add("game/values/health/enemy/random/max");
        configPaths.add("graphics/images/game_background/width");
        configPaths.add("graphics/images/game_background/height");
        configPaths.add("game/values/damage/collision/enemy/random");
        configPaths.add("game/z-indexes/main_menu_texts");
        configPaths.add("game/z-indexes/main_menu_background");
        configPaths.add("game/times/spawn/level_interval");
        configPaths.add("game/times/spawn/spawn_interval");
        return configPaths;
    }

    @Override
    public DamageCausingEntity getBasicEnemy() {
        int width = integerConfigs.get("graphics/images/entities/enemy/basic/width");
        int height = integerConfigs.get("graphics/images/entities/enemy/basic/height");
        int positionX = (int) (Math.random() * Utility.WINDOW_WIDTH);
        int positionY = (int) (Math.random() * (Utility.WINDOW_HEIGHT / 2));
        float speed = (float) (Math.random() - 1) * 5;
        int collisionDamage =
                integerConfigs.get("game/values/damage/collision/enemy/basic");
        ImageWrapper wrapper = getFlashingImageWrapper(
                stringConfigs.get("graphics/images/entities/enemy/basic/path"),
                width,
                height
        );
        Health health = new DeathHealth(
                0,
                integerConfigs.get("game/values/health/enemy/basic/max"),
                integerConfigs.get("game/values/health/enemy/basic/initial")
        );

        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setRenderable(basicEnemyFactory.getGraphics(wrapper))
                .setVolume(new BasicVolume(width, height))
                .setHealth(health)
                .setMovement(new ReflectDecorator(new ClampDecorator(new LinearMovement(speed, 0)), outOfBoundsChecker))
                .setPosition(new BasicPosition(positionX, positionY))
                .setBehaviour(basicEnemyFactory.getBehaviour())
                .setIdentifier(Identifier.Enemy)
                .setCollisionDamage(collisionDamage)
                .getDamageCausingEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public DamageCausingEntity getRandomEnemy() {
        int width = integerConfigs.get("graphics/images/entities/enemy/random/width");
        int height = integerConfigs.get("graphics/images/entities/enemy/random/height");
        int positionX = (int) (Math.random() * Utility.WINDOW_WIDTH);
        int positionY = (int) (Math.random() * (Utility.WINDOW_HEIGHT / 2));
        float speedX = (float) (Math.random() - 1) * 5;
        float speedY = (float) (Math.random() - 1) * 5;
        int collisionDamage =
                integerConfigs.get("game/values/damage/collision/enemy/random");
        ImageWrapper wrapper = getFlashingImageWrapper(
                stringConfigs.get("graphics/images/entities/enemy/random/path"),
                width,
                height
        );
        Health health = new DeathHealth(
                0,
                integerConfigs.get("game/values/health/enemy/random/max"),
                integerConfigs.get("game/values/health/enemy/random/initial")
        );

        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setRenderable(randomEnemyFactory.getGraphics(wrapper))
                .setVolume(new BasicVolume(width, height))
                .setHealth(health)
                .setMovement(new ReflectDecorator(new ClampDecorator(new LinearMovement(speedX, speedY)), outOfBoundsChecker))
                .setPosition(new BasicPosition(positionX, positionY))
                .setBehaviour(basicEnemyFactory.getBehaviour())
                .setIdentifier(Identifier.Enemy)
                .setCollisionDamage(collisionDamage)
                .getDamageCausingEntity(EntityBuilder.RESET_ALL);
    }

    private ImageWrapper getFlashingImageWrapper(
            String imagePath,
            int width,
            int height
    ) {
        return imageWrapperFactory.getFlashingImageWrapper(
                imageWrapperFactory.getDefaultImageWrapper(
                        imagePath,
                        width,
                        height
                ),
                floatConfigs.get("graphics/common/flash_decorator/initial_alpha"),
                floatConfigs.get("graphics/common/flash_decorator/alpha_step"),
                collisionColor
        );
    }

    @Override
    public DamageCausingEntity getPlayer() {
        int collisionDamage =
                integerConfigs.get("game/values/damage/collision/player");

        int width = integerConfigs.get("graphics/images/entities/player/width");
        int height = integerConfigs.get("graphics/images/entities/player/height");

        ImageWrapper wrapper = getFlashingImageWrapper(
                stringConfigs.get("graphics/images/entities/player/path"),
                width,
                height
        );
        Health playerHealth = new DeathHealth(
                0,
                integerConfigs.get("game/values/health/player/max"),
                integerConfigs.get("game/values/health/player/initial")
        );

        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setRenderable(renderableFactory.createImageGraphics(wrapper))
                .setVolume(new BasicVolume(width, height))
                .setHealth(playerHealth)
                .setMovement(new ClampDecorator(new LinearMovement(0, 0)))
                .setPosition(new BasicPosition(Utility.WINDOW_WIDTH / 2, (Utility.WINDOW_HEIGHT / 4) * 3))
                .setCollisionDamage(collisionDamage)
                .setLayerIndex(1)
                .setIdentifier(Identifier.Player)
                .getDamageCausingEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public Entity getSpawner(LinkedList<Entity> entitiesToSpawn) {
        int spawnInterval =
                integerConfigs.get("game/times/spawn/spawn_interval");
        int levelInterval =
                integerConfigs.get("game/times/spawn/level_interval");

        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setBehaviour(new SpawnerBehaviour(
                        this,
                        levelInterval,
                        spawnInterval
                ))
                .getEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public Entity getHealthBar(Entity player) {
        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setPosition(new BasicPosition(50, Utility.WINDOW_HEIGHT - 100))
                .setVolume(new BasicVolume(200, 50))
                .setRenderable(renderableFactory.createHealthBarGraphics(player))
                .setIsCollidable(false)
                .getEntity();
    }

    @Override
    public TextEntity getScoreText() {
        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setLayerIndex(integerConfigs.get("game/z-indexes/main_menu_texts"))
                .setVolume(new BasicVolume(150, 50))
                .setPosition(new BasicPosition(10, Utility.WINDOW_HEIGHT - 150))
                .setText("Score: 0")
                .setFont(renderableFactory.getFont(Font.PLAIN, 18))
                .setColor(Color.WHITE)
                .setIsCollidable(false)
                .getTextEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public TextEntity getTitleText(String text) {
        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setLayerIndex(integerConfigs.get("game/z-indexes/main_menu_texts"))
                .setPosition(new BasicPosition(0, 0))
                .setVolume(new BasicVolume(Utility.WINDOW_WIDTH, Utility.WINDOW_HEIGHT / 2))
                .setText(text)
                .setFont(renderableFactory.getFont(Font.BOLD, 48))
                .setColor(buttonStateColors.get(ButtonState.Released))
                .getTextEntity(EntityBuilder.RESET_ALL);
    }

    @Override
    public ButtonEntity getPlayButton() {
        return getButton("Play", 0);
    }

    @Override
    public ButtonEntity getExitButton() {
        int gap =
                integerConfigs.get("game/dimensions/menu/button_gap");

        return getButton("Exit", gap);
    }

    @Override
    public ButtonEntity getResumeButton() {
        return getButton("Resume", 0);
    }

    @Override
    public Entity getMenuBackground() {
        int layerIndexBackground =
                integerConfigs.get("game/z-indexes/main_menu_background");
        int backgroundWidth =
                integerConfigs.get("graphics/images/menu_background/width");
        int backgroundHeight =
                integerConfigs.get("graphics/images/menu_background/height");
        return getBackground(layerIndexBackground, backgroundWidth, backgroundHeight, "menu");
    }

    private Entity getBackground(int layerIndexBackground, int backgroundWidth, int backgroundHeight, String type) {
        EntityAwareRenderable backgroundRenderable =
                renderableFactory.createBackgroundGraphics(type);
        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setLayerIndex(layerIndexBackground)
                .setPosition(new BasicPosition(0, 0))
                .setVolume(new BasicVolume(backgroundWidth, backgroundHeight))
                .setMovement(new ResetDecorator(new LinearMovement(0, 2)))
                .setRenderable(backgroundRenderable)
                .setIsCollidable(false)
                .getEntity();
    }

    @Override
    public Entity getGameBackground() {
        int layerIndexBackground =
                integerConfigs.get("game/z-indexes/main_menu_background");
        int backgroundWidth =
                integerConfigs.get("graphics/images/game_background/width");
        int backgroundHeight =
                integerConfigs.get("graphics/images/game_background/height");
        return getBackground(layerIndexBackground, backgroundWidth, backgroundHeight, "game");
    }

    private ButtonEntity getButton(
            String text,
            int gap
    ) {
        int width =
                integerConfigs.get("game/dimensions/menu/button/width");
        int height =
                integerConfigs.get("game/dimensions/menu/button/height");
        int buttonXPosition = (Utility.WINDOW_WIDTH / 2) - (width / 2);
        int buttonYPosition = (Utility.WINDOW_HEIGHT / 2) - (height / 2) + gap;

        return entityBuilder
                .reset(EntityBuilder.RESET_ALL)
                .setPosition(new BasicPosition(buttonXPosition, buttonYPosition))
                .setVolume(new BasicVolume(width, height))
                .setText(text)
                .setColor(buttonStateColors.get(ButtonState.Released))
                .setFont(renderableFactory.getFont(Font.PLAIN, 32))
                .setButtonStateColors(buttonStateColors)
                .getButtonEntity(EntityBuilder.RESET_DATA);
    }
}
