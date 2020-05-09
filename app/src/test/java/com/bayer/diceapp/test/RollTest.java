package com.bayer.diceapp.test;

import com.bayer.diceapp.DaggerTestComponent;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.ui.roll.RollPresenter;
import com.bayer.diceapp.ui.roll.RollScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static com.bayer.diceapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="src/main/AndroidManifest.xml")
public class RollTest {
    @Inject
    RollPresenter rollPresenter;
    private RollScreen rollScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        rollScreen = mock(RollScreen.class);
        rollPresenter.attachScreen(rollScreen);
    }

    @Test
    public void testDummy(){
        verify(rollPresenter).
    }

    @After
    public void tearDown() {
        rollPresenter.detachScreen();
    }
}
