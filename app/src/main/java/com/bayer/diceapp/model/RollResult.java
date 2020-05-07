package com.bayer.diceapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RollResult {

    @SerializedName("result")
    @Expose
    private Integer result = null;

    /**
     * @return The result
     **/
    public Integer getResult() {
        return result;
    }

    /**
     * @param result The result
     **/
    public void setResult(Integer result) {
        this.result = result;
    }
}
