package com.bayer.diceapp.ui.main;

import android.widget.Toast;

import javax.inject.Inject;

import com.bayer.diceapp.di.Network;
import com.bayer.diceapp.interactor.MainInteractor;
import com.bayer.diceapp.interactor.PlayEvent;
import com.bayer.diceapp.interactor.RollsEvent;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void showRolls() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.getRolls();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RollsEvent event) {
        if (screen != null && event.getRolls() != null) {
            screen.showRolls(event.getRolls());
        }
    }

    public void playRoll(final Roll roll) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mainInteractor.playRoll(roll);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final PlayEvent event) {
        if (screen != null && event.getRollResult() != null) {
            screen.playRoll(event.getRollResult());
        }
    }

    public void editRoll(Roll roll) {
        if (screen != null) {
            screen.editRoll(roll);
        }
    }
}
