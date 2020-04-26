package com.bayer.diceapp.interactor;

import com.bayer.diceapp.DiceApplication;

import javax.inject.Inject;

public class RollInteractor {
    @Inject
    public RollInteractor() {
        DiceApplication.injector.inject(this);
    }
}
