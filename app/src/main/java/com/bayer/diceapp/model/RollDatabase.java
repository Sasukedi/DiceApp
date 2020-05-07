package com.bayer.diceapp.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Roll.class}, version = 1)
public abstract class RollDatabase extends RoomDatabase {
    public abstract RollDao rollDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile RollDatabase INSTANCE;

    static RollDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RollDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RollDatabase.class, "roll_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final RollDao rollDao;

        PopulateDbAsync(RollDatabase db) {
            rollDao = db.rollDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            rollDao.deleteAll();

            Roll roll = new Roll();
            rollDao.insert(roll);
            return null;
        }
    }
}
