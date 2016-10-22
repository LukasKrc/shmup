package lt.shmup.main.game.gameobject.tracker.valuetracker;

import lt.shmup.main.Utility;
import lt.shmup.main.game.gameobject.tracker.ValueTracker;
import lt.shmup.main.game.gameobject.health.HealthHandler;

public class HealthValueTracker extends ValueTracker<Integer> {

    private HealthHandler healthHandler;

    public HealthValueTracker(HealthHandler healthHandler, int minimumValue, int maximumValue) {
        super(minimumValue, maximumValue);
        this.healthHandler = healthHandler;
    }

    @Override
    public Integer getValue() {
        return Utility.clampInt(this.healthHandler.getHealth(), this.getMinimumValue(), this.getMaximumValue());
    }
}
