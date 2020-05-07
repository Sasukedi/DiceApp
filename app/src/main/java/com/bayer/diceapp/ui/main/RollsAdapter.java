package com.bayer.diceapp.ui.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bayer.diceapp.model.Roll;
import com.bayer.diceapp.model.Rolls;
import com.bayer.diceapp.ui.main.MainPresenter;

public class RollsAdapter extends BaseAdapter {
    private final Context mContext;
    private final Rolls rolls;
    private final MainPresenter mainPresenter;

    public RollsAdapter(Context context, Rolls rolls, MainPresenter mainPresenter) {
        this.mContext = context;
        this.rolls = rolls;
        this.mainPresenter = mainPresenter;
    }

    @Override
    public int getCount() {
        return rolls.getRolls().size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Roll roll = rolls.getRolls().get(position);

        CardView cardView = new CardView(mContext);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.playRoll(roll);
            }
        });

        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mainPresenter.editRoll(roll);
                return false;
            }
        });

        TextView textView = new TextView(mContext);

        textView.setText(roll.getName());
        textView.setTextSize(24);
        textView.setPadding(10,30,10,30);

        cardView.addView(textView);
        return cardView;
    }
}
