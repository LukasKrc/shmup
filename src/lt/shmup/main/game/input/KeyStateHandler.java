package lt.shmup.main.game.input;

public interface KeyStateHandler {
    boolean isKeyPressed(int keyCode);
    void setKeyState(int keyCode, boolean isPressed);
}
