package lt.shmup.main.game.gameobject.tracker;

public abstract class ValueTracker<TrackedType> {

    private TrackedType minimumValue, maximumValue;

    public ValueTracker(TrackedType minimumValue, TrackedType maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public TrackedType getMinimumValue() {
        return minimumValue;
    }

    public TrackedType getMaximumValue() {
        return maximumValue;
    }

    public abstract TrackedType getValue();
}
