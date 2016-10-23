//package lt.shmup.main.game.gameobject.graphics.handlers.bargraphics;
//
//import lt.shmup.main.game.gameobject.GameObject;
//import lt.shmup.main.game.gameobject.graphics.handlers.BarGraphics;
//
//import java.awt.*;
//
//public class ButtonGraphics extends BarGraphics {
//
//    private String text;
//
//    public ButtonGraphics(int width, int height, Color fillColor, Color borderColor, String text) {
//        super(width, height, fillColor, borderColor);
//        this.text = text;
//    }
//
//    @Override
//    public void render(Graphics2D graphics, GameObject gameObject) {
//        graphics.setColor(this.getFillColor());
//        graphics.fillRect(
//            gameObject.getX(),
//            gameObject.getY(),
//            this.getWidth(),
//            this.getHeight()
//        );
//        graphics.setColor(this.getBorderColor());
//        graphics.drawRect(
//            gameObject.getX(),
//            gameObject.getY(),
//            this.getWidth(),
//            this.getHeight()
//        );
//        graphics.setColor(Color.WHITE);
//        graphics.drawString(this.text, gameObject.getX() + (this.getWidth() / 2), gameObject.getY() + (this.getHeight() / 2));
//    }
//
//}
