package com.example.prm392_team1_spaapp.model;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RechargeHistory.class}, version = 1)
public abstract class RechargeHistoryDatabase extends RoomDatabase {

    public abstract RechargeHistoryDAO getHistoryDAO();
}
