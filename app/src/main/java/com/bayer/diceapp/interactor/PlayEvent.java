package com.bayer.diceapp.interactor;

import com.bayer.diceapp.model.RollResult;

public class PlayEvent {
    private RollResult rollResult;

    public PlayEvent() { }

    public RollResult getRollResult() {return rollResult;}

    public void setRollResult(RollResult rollResult) {this.rollResult = rollResult;}
}
