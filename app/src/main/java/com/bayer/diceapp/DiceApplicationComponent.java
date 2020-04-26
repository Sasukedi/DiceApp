package com.bayer.diceapp;

import javax.inject.Singleton;

import dagger.Component;

import com.bayer.diceapp.interactor.MainInteractor;
import com.bayer.diceapp.interactor.RollInteractor;
import com.bayer.diceapp.network.NetworkModule;
import com.bayer.diceapp.ui.UIModule;
import com.bayer.diceapp.ui.main.MainActivity;
import com.bayer.diceapp.ui.roll.RollPresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface DiceApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainInteractor mainInteractor);

    void inject(RollPresenter artistsPresenter);

    void inject(RollInteractor rollInteractor);
}
