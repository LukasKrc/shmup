package lt.shmup.main.game.gameobject.graphics.handlers;

import lt.shmup.main.game.gameobject.object.userInterface.ButtonObject;
import lt.shmup.main.game.gameobject.object.userInterface.ButtonState;

import java.awt.*;
import java.util.HashMap;

public class ButtonGraphicsHandler {

    public void render(Graphics2D graphics, ButtonObject buttonObject) {
        HashMap<ButtonState, Color> buttonStateFillColors = buttonObject.getButtonStateFillColors();
        HashMap<ButtonState, Color> buttonStateBorderColors = buttonObject.getButtonStateBorderColors();
        graphics.setColor(buttonStateFillColors.get(buttonObject.getState()));
        graphics.fillRect(
            (int) buttonObject.getX(),
            (int) buttonObject.getY(),
            (int) buttonObject.getWidth(),
            (int) buttonObject.getHeight()
        );
        graphics.setColor(buttonStateBorderColors.get(buttonObject.getState()));
        graphics.drawRect(
            (int) buttonObject.getX(),
            (int) buttonObject.getY(),
            (int) buttonObject.getWidth(),
            (int) buttonObject.getHeight()
        );
        graphics.setColor(Color.WHITE);
        graphics.drawString(buttonObject.getText(), buttonObject.getX() + (buttonObject.getWidth() / 2), buttonObject.getY() + (buttonObject.getHeight() / 2));
    }

}
