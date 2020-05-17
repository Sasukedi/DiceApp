package com.bayer.diceapp.interactor;

import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.network.RollApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class RollInteractor {
    RollApi rollApi;

    @Inject
    public RollInteractor(RollApi rollApi) {
        this.rollApi = rollApi;
        DiceApplication.injector.inject(this);
    }

    public void createRoll(Roll roll) {
        Call<Void> query = rollApi.postroll(roll);
        try {
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoll(Roll roll) {
        Call<Void> query = rollApi.putroll(roll);
        try {
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoll(Roll roll) {
        Call<Void> query = rollApi.deleteroll(roll.getId());
        try {
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
