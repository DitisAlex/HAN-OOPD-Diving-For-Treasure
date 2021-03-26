package project.DivingForTreasure.supportingObject;

import project.DivingForTreasure.DivingForTreasure;

public class Clock {
    private DivingForTreasure world;
    private long clock;
    private long interval;

    public Clock(DivingForTreasure world, long interval) {
        this.world = world;
        this.clock = System.currentTimeMillis();
        //Interval in Millis
        this.interval = interval;
    }

    // Functions
    public boolean clockPassed() {
        long clockForInterval = System.currentTimeMillis();
        if (clockForInterval - interval > clock) {
            resetClock();
            return true;
        }
        return false;
    }

    private void resetClock() {
        clock = System.currentTimeMillis();
    }

    //Abstract Functions
    //Override Functions
    //Getters and setters
    public DivingForTreasure getWorld() {
        return world;
    }

    public void setWorld(DivingForTreasure world) {
        this.world = world;
    }

    public long getClock() {
        return clock;
    }

    public void setClock(long clock) {
        this.clock = clock;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}

