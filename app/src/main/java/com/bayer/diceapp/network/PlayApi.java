package com.bayer.diceapp.network;

import retrofit2.Call;
import retrofit2.http.*;

import com.bayer.diceapp.model.RollResult;

public interface PlayApi {
  
  /**
   * Rolls a roll.
   * 
   * @param rollId ID of roll to roll
   * @return Call<RollResult>
   */
  
  @GET("play/{rollId}")
  Call<RollResult> playroll(
    @Path("rollId") Integer rollId
  );

  
}
