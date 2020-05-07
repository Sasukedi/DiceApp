package com.bayer.diceapp.network;

import retrofit2.Call;
import retrofit2.http.*;
import com.bayer.diceapp.model.Roll;

public interface RollApi {
  
  /**
   * Updates a roll.
   * 
   * @param body Roll to create
   * @return Call<Void>
   */
  
  @PUT("roll")
  Call<Void> putroll(
    @Body Roll body
  );

  
  /**
   * Creates a new roll.
   * 
   * @param body Roll to create
   * @return Call<Void>
   */
  
  @POST("roll")
  Call<Void> postroll(
    @Body Roll body
  );

  
  /**
   * Gets a single roll.
   * 
   * @param rollId ID of roll to return
   * @return Call<Roll>
   */
  
  @GET("roll/{rollId}")
  Call<Roll> getroll(
    @Path("rollId") Integer rollId
  );

  
  /**
   * Deletes a roll.
   * 
   * @param rollId ID of roll to delete
   * @return Call<Void>
   */
  
  @DELETE("roll/{rollId}")
  Call<Void> deleteroll(
    @Path("rollId") Integer rollId
  );

  
}
