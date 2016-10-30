package lt.Shmup.Main.GameObject.Objects.Components.EntityObservers;

import lt.Shmup.Main.GameObject.Components.Renderables.ImageGraphics;
import lt.Shmup.Main.GameObject.Objects.Components.EntityObserver;
import lt.Shmup.Main.GameObject.Objects.Entity;
import lt.Shmup.Main.Graphics.ImageWrappers.Decorators.FlashingImageWrapperDecorator;

import java.util.HashMap;

public class ImageFlashObserver implements EntityObserver {
    @Override
    public void notify(
            Entity entity,
            String eventName,
            HashMap<String, String> data
    ) {
        if (eventName.equals("damage_taken")) {
            ((FlashingImageWrapperDecorator)((ImageGraphics) entity.getRenderable()).getImageWrapper()).resetAlpha();
        }
    }

    @Override
    public EntityObserver clone() {
        return new ImageFlashObserver();
    }
}
