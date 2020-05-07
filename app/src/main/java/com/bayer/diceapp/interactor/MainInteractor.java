package com.bayer.diceapp.interactor;

import android.widget.Toast;

import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.model.Rolls;
import com.bayer.diceapp.network.PlayApi;
import com.bayer.diceapp.network.RollsApi;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class MainInteractor {
    private RollsApi rollsApi;
    private PlayApi playApi;

    @Inject
    public MainInteractor(RollsApi rollsApi, PlayApi playApi) {
        this.rollsApi = rollsApi;
        this.playApi = playApi;
        DiceApplication.injector.inject(this);
    }

    public void getRolls() {
        Call<Rolls> query = rollsApi.getrolls();
        RollsEvent event = new RollsEvent();

        try {
            Response<Rolls> response = query.execute();
            event.setRolls(response.body());
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playRoll(Roll roll) {
        Call<RollResult> query = playApi.playroll(roll.getId());
        PlayEvent event = new PlayEvent();

        try {
            Response<RollResult> response = query.execute();
            event.setRollResult(response.body());
            EventBus.getDefault().post(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
