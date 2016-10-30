package lt.Shmup;

public class Utility {
    public static final int WINDOW_HEIGHT = 768, WINDOW_WIDTH = 1024;
    public static final int MENU_ITEMS_INDEX = 1;
    public static final int BACKGROUND_INDEX = 0;
    public static final String FONT = "Helvetica";
    public static final String GAME_TITLE = "Shmup";

    public static int clampInt(int value, int minimumValue, int maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }

    public static float clampFlt(float value, float minimumValue, float maximumValue) {
        return Math.max(minimumValue, Math.min(maximumValue, value));
    }
}
