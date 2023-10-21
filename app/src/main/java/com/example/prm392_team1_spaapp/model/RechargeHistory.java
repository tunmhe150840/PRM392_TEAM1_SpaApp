package com.example.prm392_team1_spaapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "RechargeHistory")
public class RechargeHistory {
    @ColumnInfo(name = "recharge_history_id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int user_id;
    @ColumnInfo(name = "transaction_type")
    private String transactionType;
    @ColumnInfo(name = "transaction_time")
    private String transactionTime;
    @ColumnInfo(name = "amount")
    private int amount;
    @ColumnInfo(name = "status")
    private int status;
    @ColumnInfo(name = "description")
    private String description;
    @Ignore()
    public RechargeHistory(){

    }
    public RechargeHistory(int id, int user_id, String transactionType, String transactionTime, int amount, int status, String description) {
        this.id = id;
        this.user_id = user_id;
        this.transactionType = transactionType;
        this.transactionTime = transactionTime;
        this.amount = amount;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
