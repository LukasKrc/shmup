package lt.Shmup.Main.GameObject.Factories.Entity;

import lt.Shmup.Main.GameObject.Objects.Entities.ButtonEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.DamageCausingEntity;
import lt.Shmup.Main.GameObject.Objects.Entities.TextEntity;
import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.LinkedList;

public interface EntityFactory {
    DamageCausingEntity getBasicEnemy();
    DamageCausingEntity getRandomEnemy();
    DamageCausingEntity getPlayer();
    Entity getSpawner(LinkedList<Entity> entitiesToSpawn);
    Entity getHealthBar(Entity player);

    TextEntity getScoreText();

    Entity getTitleText(String text);
    ButtonEntity getPlayButton();
    ButtonEntity getExitButton();
    ButtonEntity getResumeButton();
    Entity getMenuBackground();

    Entity getGameBackground();
}
