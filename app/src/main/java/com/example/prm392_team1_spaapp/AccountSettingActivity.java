package com.example.prm392_team1_spaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_team1_spaapp.fragment.AccountFragment;

public class AccountSettingActivity extends AppCompatActivity {
    private ImageView backImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        backImage = findViewById(R.id.user_profile_back);

        backImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, AccountFragment.class);
            startActivity(intent);
        });
    }


}
