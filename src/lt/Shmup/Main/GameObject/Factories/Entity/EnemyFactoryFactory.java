package lt.Shmup.Main.GameObject.Factories.Entity;

public interface EnemyFactoryFactory {
    EnemyFactory getFactory(String type);
}
