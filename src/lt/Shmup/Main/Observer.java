package lt.Shmup.Main;

import java.util.HashMap;

public interface Observer {
    void notify(String eventName, HashMap<String, String> data);
}
