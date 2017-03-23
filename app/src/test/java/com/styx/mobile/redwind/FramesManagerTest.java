package com.styx.mobile.redwind;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amal.george on 23-03-2017
 */
public class FramesManagerTest {
    FramesManager framesManager;

    @Before
    public void setUp() {
        framesManager = new FramesManager();
    }
    @Test
    public void framesManagerMonitorsFramesProgress() {
        framesManager.frame();
        Assert.assertEquals(1, framesManager.getFramesCount());
    }
    @Test public void frameShouldBeSkipped() {
        framesManager.frame(); // Initialization frame (we need previous frame’s time)
        framesManager.frame();
        assertEquals(false, framesManager.canGo());
    }
}