package lt.Shmup.Main;

import java.util.HashMap;
import java.util.LinkedList;

public class Event {
    private LinkedList<Observer> observers = new LinkedList<>();
    private static Event instance;

    private Event() {

    }

    public static void attachObserver(Observer observer) {
        init();
        instance.observers.add(observer);
    }

    public static void notify(String eventName, HashMap<String, String> data) {
        init();
        for (Observer observer : instance.observers) {
            observer.notify(eventName, data);
        }
    }

    private static void init() {
        if (instance == null) {
            instance = new Event();
        }
    }
}
