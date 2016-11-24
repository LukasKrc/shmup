package lt.Shmup;

public class Utility {
    public static final int WINDOW_HEIGHT = 768, WINDOW_WIDTH = 1024;

    public static float clampFlt(float value, float minimumValue, float maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }
}
