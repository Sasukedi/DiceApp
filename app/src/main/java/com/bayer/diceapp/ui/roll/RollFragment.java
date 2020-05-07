package com.bayer.diceapp.ui.roll;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.bayer.diceapp.DiceApplication;
import com.bayer.diceapp.R;
import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.ui.main.MainActivity;
import com.google.gson.Gson;

import javax.inject.Inject;

public class RollFragment extends Fragment implements RollScreen {
    @Inject
    RollPresenter rollPresenter;

    private EditText nameEditText;
    private EditText nodEditText;
    private EditText nosEditText;
    private EditText modifierEditText;
    private Button saveButton;
    private Button deleteButton;

    private String method;
    private Roll roll;

    public RollFragment() {
        DiceApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        switch(getActivity().getIntent().getStringExtra(MainActivity.KEY_METHOD)) {
            case MainActivity.KEY_METHOD_CREATE:
                method = MainActivity.KEY_METHOD_CREATE;
                break;
            case MainActivity.KEY_METHOD_EDIT:
                method = MainActivity.KEY_METHOD_EDIT;
                roll = (Roll) new Gson().fromJson(getActivity().getIntent().
                        getStringExtra(MainActivity.KEY_ROLL), Roll.class);
                break;
        }

        rollPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        rollPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_roll, container, false);
        nameEditText = view.findViewById(R.id.rollEditText);
        nodEditText = view.findViewById(R.id.numberOfDiceEditText);
        nosEditText = view.findViewById(R.id.numberOfSidesEditText);
        modifierEditText = view.findViewById(R.id.modifierEditText);
        saveButton = view.findViewById(R.id.saveButton);
        deleteButton = view.findViewById(R.id.deleteButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll.setName(nameEditText.getText().toString());
                roll.setNumberOfDice(Integer.parseInt(nodEditText.getText().toString()));
                roll.setNumberOfSides(Integer.parseInt(nosEditText.getText().toString()));
                roll.setModifier(Integer.parseInt(modifierEditText.getText().toString()));

                switch(method) {
                    case MainActivity.KEY_METHOD_CREATE:
                        //TODO create roll POST
                        break;
                    case MainActivity.KEY_METHOD_EDIT:
                        //TODO update roll PUT
                        break;
                }
                //TODO close activity
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(method.equals(MainActivity.KEY_METHOD_EDIT)) {
                    //TODO delete roll
                }
                //TODO close activity
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        showRoll();
    }

    @Override
    public void showRoll() {
        nameEditText.setText(roll.getName());
        nodEditText.setText(roll.getNumberOfDice().toString());
        nosEditText.setText(roll.getNumberOfSides().toString());
        modifierEditText.setText(roll.getModifier().toString());
    }
}
