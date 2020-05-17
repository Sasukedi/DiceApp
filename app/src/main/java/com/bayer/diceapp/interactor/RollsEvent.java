package com.bayer.diceapp.interactor;

import com.bayer.diceapp.model.Rolls;

public class RollsEvent {
    private Rolls rolls;

    public RollsEvent() { }

    public Rolls getRolls() {return rolls;}

    public void setRolls(Rolls rolls) {this.rolls = rolls;}
}
