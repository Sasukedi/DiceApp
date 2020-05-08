package com.bayer.diceapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import javax.inject.Inject;

import com.bayer.diceapp.R;
import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.RollResult;
import com.bayer.diceapp.model.Rolls;
import com.bayer.diceapp.ui.roll.RollActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter mainPresenter;

    public static final String KEY_ROLL = "ROLL";
    public static final String KEY_METHOD = "METHOD";
    public static final String KEY_METHOD_EDIT = "EDIT";
    public static final String KEY_METHOD_CREATE = "CREATE";

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DiceApplication application = (DiceApplication) this.getApplication();

        DiceApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.showRolls();
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRoll();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showRolls(Rolls rolls) {
        RollsAdapter rollsAdapter = new RollsAdapter(this, rolls, mainPresenter);
        gridView.setAdapter(rollsAdapter);
    }

    @Override
    public void playRoll(RollResult rollResult) {
        Toast.makeText(this, String.valueOf(rollResult.getResult()),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editRoll(Roll roll) {
        Intent intent = new Intent(MainActivity.this, RollActivity.class);
        intent.putExtra(KEY_METHOD, KEY_METHOD_EDIT);
        intent.putExtra(KEY_ROLL, new Gson().toJson(roll));
        startActivity(intent);
    }

    public void createRoll() {
        Intent intent = new Intent(MainActivity.this, RollActivity.class);
        intent.putExtra(KEY_METHOD, KEY_METHOD_CREATE);
        startActivity(intent);
    }
}
