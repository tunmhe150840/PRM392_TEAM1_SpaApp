package com.example.prm392_team1_spaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_team1_spaapp.model.Money;

import java.util.List;


public class WithdrawDetailActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    EditText edt1;
    ImageView imv2;
    TextView totalmoney;
    Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_detail);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        edt1 = findViewById(R.id.money_input);
        imv2 = findViewById(R.id.back2);
        totalmoney = findViewById(R.id.totalMoney);
        submit = findViewById(R.id.confirm_button2);
        TransferMoneyDatabaseHelper transferMoneyDatabaseHelper = new TransferMoneyDatabaseHelper(WithdrawDetailActivity.this);
        List<Money> listMoney = transferMoneyDatabaseHelper.getAll();
        Money moneyRoot = new Money();
        //Money moneyRoot = listMoney.get(0);
        totalmoney.setText(""+ moneyRoot.getTotalMoney());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn1.getText());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn2.getText());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn3.getText());

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn4.getText());

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn5.getText());

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(btn6.getText());

            }
        });

        imv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WithdrawDetailActivity.this, RechargeWithdraw.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float totalMoney =Float.parseFloat(edt1.getText().toString().trim()) - moneyRoot.getTotalMoney();
                transferMoneyDatabaseHelper.decreaseMoney(moneyRoot.getId(),totalMoney);
                recreate();
            }
        });
    }
}