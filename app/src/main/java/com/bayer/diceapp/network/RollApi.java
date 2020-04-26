package com.bayer.diceapp.network;

import com.bayer.diceapp.model.RollsResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RollApi {
    @GET("rolls")
    Call<RollsResult> getRolls();
}
