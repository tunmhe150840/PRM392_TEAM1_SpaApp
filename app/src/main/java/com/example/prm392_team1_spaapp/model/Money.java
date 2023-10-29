package com.example.prm392_team1_spaapp.model;

import java.io.Serializable;

public class Money implements Serializable {
    private int id;
    private float totalMoney;
    private String friendName;
    private int isZaloPay;
    private String numberPhone;

    public Money() {
    }

    public Money(int id, float totalMoney, String friendName, int isZaloPay, String numberPhone) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.friendName = friendName;
        this.isZaloPay = isZaloPay;
        this.numberPhone = numberPhone;
    }

    public Money(float totalMoney, String friendName, int isZaloPay, String numberPhone) {
        this.totalMoney = totalMoney;
        this.friendName = friendName;
        this.isZaloPay = isZaloPay;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int isZaloPay() {
        return isZaloPay;
    }

    public void setZaloPay(int zaloPay) {
        isZaloPay = zaloPay;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
