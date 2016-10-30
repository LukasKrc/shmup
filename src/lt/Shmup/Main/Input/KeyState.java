package lt.Shmup.Main.Input;

public interface KeyState {
    boolean isKeyPressed(int keyCode);
    void setKeyState(int keyCode, boolean isPressed);
}
