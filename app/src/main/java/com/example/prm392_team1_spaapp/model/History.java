package com.example.prm392_team1_spaapp.model;

import androidx.room.PrimaryKey;


public class History {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int user_id;

    private String transactionType;

    private String transactionTime;

    private int amount;

    private int status;

    private String description;

    public History(){

    }
    public History(int id, int user_id, String transactionType, String transactionTime, int amount, int status, String description) {
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
