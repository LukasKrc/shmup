package lt.shmup.main.game.gameobject.object.userInterface;

import lt.shmup.main.game.gameobject.Identifier;
import lt.shmup.main.game.gameobject.Renderable;
import lt.shmup.main.game.gameobject.graphics.handlers.ButtonGraphicsHandler;

import java.awt.*;
import java.util.HashMap;

public class ButtonObject implements Renderable {

    private Identifier identifier;

    private ButtonGraphicsHandler buttonGraphicsHandler;

    private ButtonState state;

    private HashMap<ButtonState, Color> buttonStateFillColors;

    private HashMap<ButtonState, Color> buttonStateBorderColors;

    private float x, y, width, height;

    private String text;

    public ButtonObject(
        ButtonGraphicsHandler buttonGraphicsHandler,
        HashMap<ButtonState, Color> buttonStateFillColors,
        HashMap<ButtonState, Color> buttonStateBorderColors,
        float x,
        float y,
        float width,
        float height,
        String text
    ) {
        this.buttonGraphicsHandler = buttonGraphicsHandler;
        this.state = ButtonState.Released;
        this.identifier = Identifier.InterfaceObject;
        this.buttonStateFillColors = buttonStateFillColors;
        this.buttonStateBorderColors = buttonStateBorderColors;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public HashMap<ButtonState, Color> getButtonStateFillColors() {
        return buttonStateFillColors;
    }

    public HashMap<ButtonState, Color> getButtonStateBorderColors() {
        return buttonStateBorderColors;
    }

    public ButtonState getState() {
        return state;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        this.buttonGraphicsHandler.render(graphics2D, this);
    }

}
