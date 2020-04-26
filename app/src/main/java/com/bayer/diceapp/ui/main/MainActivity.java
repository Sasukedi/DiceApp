package com.bayer.diceapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import com.bayer.diceapp.R;
import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.ui.roll.RollActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DiceApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showRolls() {
        Intent intent = new Intent(MainActivity.this, RollActivity.class);
        startActivity(intent);
    }
}
