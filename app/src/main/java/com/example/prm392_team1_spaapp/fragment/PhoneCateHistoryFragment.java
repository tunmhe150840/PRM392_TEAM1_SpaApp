package com.example.prm392_team1_spaapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prm392_team1_spaapp.R;
import com.example.prm392_team1_spaapp.dataLocal.DataLocalManager;
import com.example.prm392_team1_spaapp.model.Account;
import com.example.prm392_team1_spaapp.model.AccountDatabase;


public class PhoneCateHistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_categories_phone, container, false);



        return view;
    }
}
