package com.bayer.diceapp.interactor;

import com.bayer.diceapp.DiceApplication;

import javax.inject.Inject;

public class MainInteractor {
    @Inject
    public MainInteractor() {
        DiceApplication.injector.inject(this);
    }
}
