package lt.shmup.main;

/**
 * Created by lukas on 16.9.24.
 */
public class Utility {

    public static final int WINDOW_HEIGHT = 480, WINDOW_WIDTH = 600;

    public static int clamp(int value, int minimumValue, int maximumValue) {
        if (value >= maximumValue) {
            return maximumValue;
        } else if (value <= minimumValue) {
            return minimumValue;
        } else {
            return value;
        }
    }
}
