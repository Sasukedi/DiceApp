package com.bayer.diceapp.interactor;

import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.network.RollApi;

import java.io.IOException;

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
        Call<Void> query = rollApi.deleteroll(roll.getId());
        try {
            Response<Void> response = query.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateRoll(Roll roll) {
        Call<Void> query = rollApi.deleteroll(roll.getId());
        try {
            Response<Void> response = query.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String deleteRoll(Roll roll) {
        Call<Void> query = rollApi.deleteroll(roll.getId());
        try {
            Response<Void> response = query.execute();
            if (response.code() == 200) {
                return "Deleted";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Couldn't delete";
    }
}
