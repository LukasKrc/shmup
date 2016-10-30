package lt.Shmup.Main.GameObject.Objects.Components;

import lt.Shmup.Main.GameObject.Objects.Entity;

import java.util.HashMap;

public interface EntityObserver {
    void notify(Entity entity, String eventName, HashMap<String, String> data);
    EntityObserver clone();
}
