package com.bayer.diceapp;

import com.bayer.diceapp.mock.MockNetworkModule;
import com.bayer.diceapp.test.MainTest;
import com.bayer.diceapp.test.RollTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends DiceApplicationComponent {
    void inject(MainTest mainTest);

    void inject(RollTest rollTest);
}
