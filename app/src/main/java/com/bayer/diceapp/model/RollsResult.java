package com.bayer.diceapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RollsResult {
    @SerializedName("rolls")
    @Expose
    private List<Roll> rolls;

    public List<Roll> getRolls() {return rolls;}

    public void setRolls(List<Roll> rolls) {this.rolls = rolls;}
}
