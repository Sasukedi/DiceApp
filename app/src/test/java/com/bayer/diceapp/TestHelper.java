package com.bayer.diceapp;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        DiceApplication application = (DiceApplication) RuntimeEnvironment.application;
        DiceApplicationComponent injector = DaggerTestComponent.builder().
                testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }
}
