package com.example.prm392_team1_spaapp.dataLocal;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_USERNAME = "PREF_USERNAME";
    private static final String PREF_MONEY = "PREF_MONEY";
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null){
            instance = new DataLocalManager();
        }

        return instance;
    }

    public void setPrefUsername(String username){
        DataLocalManager.getInstance().mySharePreferences.putStringValue(PREF_USERNAME, username);
    }

    public String getPrefUsername() {
        return DataLocalManager.getInstance().mySharePreferences.getStringValue(PREF_USERNAME);
    }

    public void setPrefMoney(float money){
        DataLocalManager.getInstance().mySharePreferences.putFloatValue(PREF_MONEY, money);
    }

    public float getPrefMoney() {
        return DataLocalManager.getInstance().mySharePreferences.getFloatValue(PREF_MONEY);
    }
}
