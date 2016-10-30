package lt.Shmup.Main;

import lt.Shmup.*;
import lt.Shmup.Container;
import lt.Shmup.Main.Command.Commands.PauseGameCommand;
import lt.Shmup.Main.Command.Commands.StartGameCommand;
import lt.Shmup.Main.Command.Commands.StopGameCommand;
import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderer;
import lt.Shmup.Main.GameObject.Components.Renderables.TextRenderers.DefaultTextRenderer;
import lt.Shmup.Main.GameObject.Factories.Entity.EntityFactory;
import lt.Shmup.Main.GameObject.ObjectHandler;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.DamageTakenObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ImageFlashObserver;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObservers.ProjectileSpawnObserver;
import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Input.Commands.Keyboard.Firing.FirePressed;
import lt.Shmup.Main.Input.Commands.Keyboard.Firing.FireReleased;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.Pressed.MovementHorizontalCommand;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.Pressed.MovementVerticalCommand;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released.StoppingHorizontalCommand;
import lt.Shmup.Main.Input.Commands.Keyboard.Movement.Released.StoppingVerticalCommand;
import lt.Shmup.Main.Input.KeyState;
import lt.Shmup.Main.Input.KeyboardInputHandler;
import lt.Shmup.Main.Input.Commands.Mouse.ButtonClickCommand;
import lt.Shmup.Main.Input.Commands.Mouse.ButtonHoverCommand;
import lt.Shmup.Main.Input.MouseInputHandler;
import lt.Shmup.Main.Input.MouseInputHandlers.DefaultMouseInputHandler;
import lt.Shmup.Main.Observers.GameOverObserver;
import lt.Shmup.Main.Observers.ScoreIncreaseObserver;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

public class Initializer {;
    private Game game;
    private HashMap<GameState, ObjectHandler> objectHandlers;
    private MouseInputHandler mouseInputHandler;
    private KeyboardInputHandler keyboardInputHandler;
    private EntityFactory entityFactory;

    public Initializer(
            Game game
    ) {
        this.game = game;
    }

    public void setObjectHandlers(
            HashMap<GameState, ObjectHandler> objectHandlers
    ) {
        this.objectHandlers = objectHandlers;
    }

    public void initialize() {
        (new ClassRegistrator()).createMainDependencies();
        populateLocalFields();
    }

    public void createObjects() {
        createInitialMenuObjects();
        createGameObjects();
        createPauseMenuObjects();
        createGameOverMenuObjects();
    }

    private void populateLocalFields() {
        mouseInputHandler =
                (MouseInputHandler) Container.get(MouseInputHandler.class);
        entityFactory =
                (EntityFactory) Container.get(EntityFactory.class);
        keyboardInputHandler = (KeyboardInputHandler)
                Container.get(KeyboardInputHandler.class);
    }

    private void createInitialMenuObjects() {
        ObjectHandler objectHandler = objectHandlers.get(GameState.Menu);

        Entity titleText = entityFactory.getTitleText(Config.str("game/title"));
        ButtonEntity playButton = entityFactory.getPlayButton();
        ButtonEntity exitButton = entityFactory.getExitButton();
        Entity background = entityFactory.getMenuBackground();
        addMenuCommands(playButton, exitButton);

        objectHandler.addEntity(titleText);
        objectHandler.addEntity(playButton);
        objectHandler.addEntity(exitButton);
        objectHandler.addEntity(background);
    }

    private void addMenuCommands(ButtonEntity playButton, ButtonEntity exitButton) {
        mouseInputHandler.addCommand(
                DefaultMouseInputHandler.CLICKED_EVENT,
                new ButtonClickCommand(playButton, new StartGameCommand(game))
        );
        mouseInputHandler.addCommand(
                DefaultMouseInputHandler.MOVED_EVENT,
                new ButtonHoverCommand(playButton)
        );
        mouseInputHandler.addCommand(
                DefaultMouseInputHandler.CLICKED_EVENT,
                new ButtonClickCommand(exitButton, new StopGameCommand(game))
        );
        mouseInputHandler.addCommand(
                DefaultMouseInputHandler.MOVED_EVENT,
                new ButtonHoverCommand(exitButton)
        );
    }

    private void createGameObjects() {
        ObjectHandler objectHandler = objectHandlers.get(GameState.Running);
        int playerXSpeed =
                Config.intg("game/movements/player/horizontal");
        int playerYSpeed =
                Config.intg("game/movements/player/vertical");

        Entity player = entityFactory.getPlayer();
        Entity healthBar = entityFactory.getHealthBar(player);
        Entity basicEnemy = entityFactory.getBasicEnemy();
        Entity randomEnemy = entityFactory.getRandomEnemy();
        LinkedList<Entity> entitiesToSpawn = new LinkedList<>();
        entitiesToSpawn.add(basicEnemy);
        entitiesToSpawn.add(basicEnemy.clone());
        entitiesToSpawn.add(randomEnemy);
        Entity spawner = entityFactory.getSpawner(entitiesToSpawn);
        TextEntity scoreText = entityFactory.getScoreText();
        Entity background = entityFactory.getGameBackground();

        attachObservers(player, scoreText);
        addCommands(playerXSpeed, playerYSpeed, player);

        objectHandler.addEntity(scoreText);
        objectHandler.addEntity(spawner);
        objectHandler.addEntity(player);
        objectHandler.addEntity(healthBar);
        objectHandler.addEntity(background);
    }

    private void attachObservers(Entity player, TextEntity scoreText) {
        Event.attachObserver(new GameOverObserver(game));
        Event.attachObserver(new ScoreIncreaseObserver(scoreText));
        player.attachObserver(new ImageFlashObserver());
        player.attachObserver(new DamageTakenObserver());
        player.attachObserver(new ProjectileSpawnObserver());
    }

    private void addCommands(int playerXSpeed, int playerYSpeed, Entity player) {
        PauseGameCommand pauseGameCommand = new PauseGameCommand(game);
        KeyState keyStateContainer = keyboardInputHandler.getKeyStateContainer();
        MovementVerticalCommand moveUpCommand = new MovementVerticalCommand(player, -playerYSpeed);
        MovementVerticalCommand moveDownCommand = new MovementVerticalCommand(player, playerYSpeed);
        MovementHorizontalCommand moveRightCommand = new MovementHorizontalCommand(player, playerXSpeed);
        MovementHorizontalCommand moveLeftCommand = new MovementHorizontalCommand(player, -playerXSpeed);
        FirePressed firePressedCommand = new FirePressed(player);
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_SPACE, firePressedCommand);
        keyboardInputHandler.addKeyReleasedCommand(KeyEvent.VK_SPACE, new FireReleased(firePressedCommand));
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_W, moveUpCommand);
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_S, moveDownCommand);
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_D, moveRightCommand);
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_A, moveLeftCommand);
        keyboardInputHandler.addKeyPressedCommand(KeyEvent.VK_ESCAPE, pauseGameCommand);
        keyboardInputHandler.addKeyReleasedCommand(KeyEvent.VK_W, new StoppingVerticalCommand(player, keyStateContainer, KeyEvent.VK_S, moveDownCommand));
        keyboardInputHandler.addKeyReleasedCommand(KeyEvent.VK_S, new StoppingVerticalCommand(player, keyStateContainer, KeyEvent.VK_W, moveUpCommand));
        keyboardInputHandler.addKeyReleasedCommand(KeyEvent.VK_D, new StoppingHorizontalCommand(player, keyStateContainer, KeyEvent.VK_A, moveLeftCommand));
        keyboardInputHandler.addKeyReleasedCommand(KeyEvent.VK_A, new StoppingHorizontalCommand(player, keyStateContainer, KeyEvent.VK_D, moveRightCommand));
    }

    private void createPauseMenuObjects() {
        ObjectHandler objectHandler = objectHandlers.get(GameState.Paused);
        ButtonEntity resumeButton = entityFactory.getResumeButton();
        ButtonEntity exitButton = entityFactory.getExitButton();
        Entity background = entityFactory.getMenuBackground();

        addMenuCommands(resumeButton, exitButton);

        objectHandler.addEntity(background);
        objectHandler.addEntity(resumeButton);
        objectHandler.addEntity(exitButton);
    }

    private void createGameOverMenuObjects() {
        ObjectHandler objectHandler = objectHandlers.get(GameState.Over);

        Entity gameOverText = entityFactory.getTitleText("Game over");

        objectHandler.addEntity(gameOverText);
    }
}
