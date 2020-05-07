package com.bayer.diceapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName="roll_table")
public class Roll {

    @PrimaryKey
    @ColumnInfo(name="id")
    @SerializedName("id")
    @Expose
    @NonNull
    private Integer id;

    @ColumnInfo(name="name")
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo(name="numberOfDice")
    @SerializedName("numberOfDice")
    @Expose
    private Integer numberOfDice;

    @ColumnInfo(name="numberOfSides")
    @SerializedName("numberOfSides")
    @Expose
    private Integer numberOfSides;

    @ColumnInfo(name="modifier")
    @SerializedName("modifier")
    @Expose
    private Integer modifier;

    /**
     * @return The id
     **/
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     **/
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     **/
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The numberOfDice
     **/
    public Integer getNumberOfDice() {
        return numberOfDice;
    }

    /**
     * @param numberOfDice The numberOfDice
     **/
    public void setNumberOfDice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    /**
     * @return The numberOfSides
     **/
    public Integer getNumberOfSides() {
        return numberOfSides;
    }

    /**
     * @param numberOfSides The numberOfSides
     **/
    public void setNumberOfSides(Integer numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    /**
     * @return The modifier
     **/
    public Integer getModifier() {
        return modifier;
    }

    /**
     * @param modifier The modifier
     **/
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }
}
