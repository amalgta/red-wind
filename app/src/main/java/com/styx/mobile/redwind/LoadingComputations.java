package com.styx.mobile.redwind;

/**
 * Created by amal.george on 23-03-2017
 */

public class LoadingComputations {
    private float density;
    private long ANIMATION_LENGTH=1000;

    public LoadingComputations(float density) {
        this.density = density;
    }

    public float dpToPx(int size) {
        return density * size;
    }
    public double verticalPosition(long time, long offset) {
        double X = 2 * Math.PI * (time + offset) / ANIMATION_LENGTH;
        return (Math.sin(X) + 1) / 2.;
    }
}
