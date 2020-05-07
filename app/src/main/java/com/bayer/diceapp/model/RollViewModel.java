package com.bayer.diceapp.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RollViewModel extends AndroidViewModel {
    private RollRepository rollRepository;
    private LiveData<List<Roll>> rollAll;

    public RollViewModel(Application application) {
        super(application);
        rollRepository = new RollRepository(application);
        rollAll = rollRepository.getAllRoll();
    }

    LiveData<List<Roll>> getRollAll() {
        return rollAll;
    }

    void insert(Roll roll) { rollRepository.insert(roll);
    }
}
