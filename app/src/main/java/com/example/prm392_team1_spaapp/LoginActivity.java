package com.example.prm392_team1_spaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_team1_spaapp.dataLocal.DataLocalManager;
import com.example.prm392_team1_spaapp.model.Account;
import com.example.prm392_team1_spaapp.model.AccountDatabase;


public class LoginActivity extends AppCompatActivity {
    EditText et_username;
    EditText et_password;
    TextView tv_register;
    ImageView img_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        tv_register = findViewById(R.id.tv_register);
        img_login = findViewById(R.id.img_login);

    }

    public void clickOnLogin(View view) {
        if (et_username.getText().toString() == "" || et_password.getText().toString() == ""){
            return;
        }

        Account account = AccountDatabase.getInstance(this).getAccountDAO().getAccount(
                et_username.getText().toString().trim(), et_password.getText().toString().trim()
        );
        if (account != null) {
            DataLocalManager.getInstance().setPrefUsername(account.getUsername());
            DataLocalManager.getInstance().setPrefMoney(account.getMoney());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
