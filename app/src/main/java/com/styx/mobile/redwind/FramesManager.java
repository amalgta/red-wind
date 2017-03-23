package com.styx.mobile.redwind;

import java.util.concurrent.TimeUnit;

/**
 * Created by amal.george on 23-03-2017
 */

public class FramesManager {
    int frames;
    long lastFrame;
    private int fps;
    private long timeSpan;
    private static final double TIME_PER_FRAME = 1000 / 30  ;
    private long timeFrame;

    public int getFramesCount() {
        return frames;
    }

    public void frame() {
        if (canGo()) {
            timeFrame %= TIME_PER_FRAME;
        }
        long currentFrame = System.currentTimeMillis();
        long timeStep = currentFrame - lastFrame;
        timeFrame += timeStep;
        timeSpan += timeStep;
        if (timeSpan > TimeUnit.SECONDS.toMillis(1)) {
            timeSpan = 0;
            fps = getFramesCount();
            frames = 0;
        }
        if (canGo()) {
            frames++;
            timeFrame = 0;
        }
        if (canGo()) {
            frames++;
        }
        lastFrame = currentFrame;
    }

    public int fps() {
        return fps;
    }

    public boolean canGo() {
        return timeFrame > TIME_PER_FRAME;
    }
}
