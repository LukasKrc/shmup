package lt.shmup.main;

public class Utility {

    public static final int WINDOW_HEIGHT = 480, WINDOW_WIDTH = 600;

    public static int clampInt(int value, int minimumValue, int maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }

    public static float clampFlt(float value, float minimumValue, float maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }
}
