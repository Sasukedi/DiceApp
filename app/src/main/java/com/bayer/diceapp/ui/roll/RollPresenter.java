package com.bayer.diceapp.ui.roll;

import javax.inject.Inject;

import com.bayer.diceapp.di.Network;
import com.bayer.diceapp.interactor.RollInteractor;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.ui.Presenter;

import java.util.concurrent.Executor;

public class RollPresenter extends Presenter<RollScreen> {
    Executor networkExecutor;
    RollInteractor rollInteractor;

    @Inject
    public RollPresenter(@Network Executor networkExecutor, RollInteractor rollInteractor) {
        this.networkExecutor = networkExecutor;
        this.rollInteractor = rollInteractor;
    }

    @Override
    public void attachScreen(RollScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void createRoll(final Roll roll) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                 rollInteractor.createRoll(roll);
            }
        });
    }

    public void updateRoll(final Roll roll) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                 rollInteractor.updateRoll(roll);
            }
        });
    }

    public void deleteRoll(final Roll roll) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                 rollInteractor.deleteRoll(roll);
            }
        });
    }
}
