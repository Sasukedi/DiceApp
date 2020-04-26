package com.bayer.diceapp.ui.main;

import javax.inject.Inject;

import com.bayer.diceapp.di.Network;
import com.bayer.diceapp.interactor.MainInteractor;
import com.bayer.diceapp.ui.Presenter;

import java.util.concurrent.Executor;

public class MainPresenter extends Presenter<MainScreen> {
    Executor networkExecutor;
    MainInteractor mainInteractor;

    @Inject
    public MainPresenter(@Network Executor networkExecutor, MainInteractor mainInteractor) {
        this.networkExecutor = networkExecutor;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
