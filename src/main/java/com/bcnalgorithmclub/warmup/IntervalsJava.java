package com.bcnalgorithmclub.warmup;

import static java.lang.Math.max;
import static java.lang.Math.min;

class IntervalsJava {
    boolean overlapping(IntervalJava interval, IntervalJava interval2) {
        return max(interval.getStartTime(), interval2.getStartTime()) <= min(interval.getEndTime(), interval2.getEndTime());
    }

    private boolean firstOverlapsSecond(IntervalJava interval, IntervalJava interval2) {
        return (interval2.getStartTime()  <= interval.getEndTime() && interval2.getStartTime() >= interval.getStartTime()) ||
                (interval.getStartTime() >= interval2.getStartTime() && interval.getEndTime() <= interval2.getEndTime());
    }
}

class IntervalJava {
    private final int startTime;
    private final int endTime;

    IntervalJava(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    int getStartTime() {
        return startTime;
    }

    int getEndTime() {
        return endTime;
    }
}
