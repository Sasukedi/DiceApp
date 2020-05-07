package com.bayer.diceapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RollDao {
    @Query("SELECT * FROM roll_table")
    LiveData<List<Roll>> getAll();

    @Query("SELECT * FROM roll_table WHERE id IN (:rollIds)")
    LiveData<List<Roll>> loadAllByIds(int[] rollIds);

    @Query("SELECT * FROM roll_table WHERE id = (:rollId) LIMIT 1")
    LiveData<Roll> findById(int rollId);

    @Query("SELECT * from roll_table ORDER BY name ASC")
    LiveData<List<Roll>> getInNameOrder();

    @Insert
    void insert(Roll roll);

    @Insert
    void insertAll(Roll... rolls);

    @Delete
    void delete(Roll roll);

    @Query("DELETE FROM roll_table")
    void deleteAll();
}
