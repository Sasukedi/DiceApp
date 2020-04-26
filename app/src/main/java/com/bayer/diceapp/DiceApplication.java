package com.bayer.diceapp;

import android.app.Application;

import com.bayer.diceapp.ui.UIModule;

public class DiceApplication extends Application {

    public static DiceApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerDiceApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
