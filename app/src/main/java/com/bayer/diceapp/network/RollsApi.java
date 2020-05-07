package com.bayer.diceapp.network;

import retrofit2.Call;
import retrofit2.http.*;

import com.bayer.diceapp.model.Rolls;

public interface RollsApi {
  
  /**
   * Gets all stored rolls.
   * 
   * @return Call<Rolls>
   */
  
  @GET("rolls")
  Call<Rolls> getrolls();
    

  
}
