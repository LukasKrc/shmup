package lt.shmup.main.game.userinterface;


import java.awt.*;
import java.util.LinkedList;

public class InterfaceHandler {

    private LinkedList<InterfaceObject> interfaceObjects = new LinkedList<>();

    public void addInterfaceObject(InterfaceObject interfaceObject) {
        this.interfaceObjects.add(interfaceObject);
    }

    public void removeInterfaceObject(InterfaceObject interfaceObject) {
        this.interfaceObjects.remove(interfaceObject);
    }

    public void update() {
        for (InterfaceObject interfaceObject : this.interfaceObjects) {
            interfaceObject.update();
        }
    }

    public void render(Graphics graphics) {
        for (InterfaceObject interfaceObject : this.interfaceObjects) {
            interfaceObject.render(graphics);
        }
    }
}
