package com.bayer.diceapp.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RollRepository {
    private RollDao rollDao;
    private LiveData<List<Roll>> allRoll;

    RollRepository(Application application) {
        RollDatabase db = RollDatabase.getDatabase(application);
        rollDao = db.rollDao();
        allRoll = rollDao.getAll();
    }

    LiveData<List<Roll>> getAllRoll() {
        return allRoll;
    }

    void insert(Roll roll) {
        new insertAsyncTask(rollDao).execute(roll);
    }

    private static class insertAsyncTask extends AsyncTask<Roll, Void, Void> {

        private RollDao mAsyncTaskDao;

        insertAsyncTask(RollDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Roll... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
