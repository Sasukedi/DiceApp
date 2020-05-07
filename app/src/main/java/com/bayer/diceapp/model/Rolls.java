package com.bayer.diceapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rolls {

    @SerializedName("rolls")
    @Expose
    private List<Roll> rolls = new ArrayList<Roll>();

    /**
     * @return The rolls
     **/
    public List<Roll> getRolls() {
        return rolls;
    }

    /**
     * @param rolls The rolls
     */
    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }
}
