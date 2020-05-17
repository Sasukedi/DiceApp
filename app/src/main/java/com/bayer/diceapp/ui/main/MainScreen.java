package com.bayer.diceapp.ui.main;

import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.model.Rolls;

public interface MainScreen {
    void showRolls(Rolls rolls);
    void playRoll(RollResult rollResult);
    void editRoll(Roll roll);
}
