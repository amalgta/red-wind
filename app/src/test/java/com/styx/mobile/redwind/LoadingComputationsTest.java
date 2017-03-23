package com.styx.mobile.redwind;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by amal.george on 23-03-2017
 */
public class LoadingComputationsTest {
    private LoadingComputations loadingComputations;
    @Test public void checksComputerAbilityToMultiply() {
        loadingComputations = new LoadingComputations(2.5f);
        Assert.assertEquals(2.5f, loadingComputations.dpToPx(1), 0.001);
    }
    @Test public void doubleCheckConversionIsCorrect() {
        loadingComputations = new LoadingComputations(2.5f);
        Assert.assertEquals(7.5f, loadingComputations.dpToPx(3), 0.001);
    }
    @Test public void convertForDensityEqual3() {
        loadingComputations = new LoadingComputations(3.f);
        Assert.assertEquals(9.f, loadingComputations.dpToPx(3), 0.001);
    }
    @Test public void calculatesSinusoidResultBasedOnTimeWithOffset125ms() {
        loadingComputations = new LoadingComputations(0.f);
        Assert.assertEquals((0. + 1)/2, loadingComputations.verticalPosition(-125, 125L), 0.002);
        Assert.assertEquals((Math.sqrt(2)/2 + 1)/2, loadingComputations.verticalPosition(0, 125L), 0.002);
        Assert.assertEquals((1 + 1)/2, loadingComputations.verticalPosition(125, 125L), 0.002);
    }
}