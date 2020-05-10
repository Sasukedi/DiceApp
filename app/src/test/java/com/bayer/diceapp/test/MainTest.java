package com.bayer.diceapp.test;

import com.bayer.diceapp.DaggerTestComponent;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.model.Rolls;
import com.bayer.diceapp.ui.main.MainPresenter;
import com.bayer.diceapp.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.bayer.diceapp.TestHelper.setTestInjector;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="src/main/AndroidManifest.xml")
public class MainTest {
    @Inject
    MainPresenter mainPresenter;

    private MainScreen mainScreen;

    public MainTest() {}

    @Before
    public void setup() {
        //System.out.println("hm");
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testShowRolls() {
        final Rolls tempRolls = new Rolls();
        List<Roll> rollList = new ArrayList<Roll>();
        Roll r1 = new Roll();
        r1.setId(1);
        r1.setName("1");
        r1.setNumberOfDice(1);
        r1.setNumberOfSides(1);
        r1.setModifier(1);
        Roll r2 = new Roll();
        r2.setId(2);
        r2.setName("2");
        r2.setNumberOfDice(2);
        r2.setNumberOfSides(2);
        r2.setModifier(2);
        rollList.add(r1);
        rollList.add(r2);
        tempRolls.setRolls(rollList);

        mainPresenter.showRolls();

        ArgumentCaptor<Rolls> argumentCaptor = ArgumentCaptor.forClass(Rolls.class);
        verify(mainScreen).showRolls(argumentCaptor.capture());
        Rolls capturedArgument = argumentCaptor.<Rolls> getValue();
        assert(capturedArgument.getRolls().size() == tempRolls.getRolls().size());
        assert(capturedArgument.getRolls().get(0).getId() == tempRolls.getRolls().get(0).getId());
        assert(capturedArgument.getRolls().get(1).getId() == tempRolls.getRolls().get(1).getId());
    }

    @Test
    public void testPlayRolls() {
        Roll r1 = new Roll();
        r1.setId(1);
        RollResult rollResult1 = new RollResult();
        rollResult1.setResult(Integer.valueOf(1));
        RollResult rollResult2 = new RollResult();
        rollResult2.setResult(Integer.valueOf(2));

        mainPresenter.playRoll(r1);
        ArgumentCaptor<RollResult> argumentCaptor = ArgumentCaptor.forClass(RollResult.class);
        verify(mainScreen).playRoll(argumentCaptor.capture());
        RollResult capturedArgument = argumentCaptor.<RollResult> getValue();
        assert(capturedArgument.getResult().equals(rollResult1.getResult()));
        assert(!capturedArgument.getResult().equals(rollResult2.getResult()));
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
