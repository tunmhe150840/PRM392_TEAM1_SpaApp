package com.example.prm392_team1_spaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_team1_spaapp.model.Service;

public class ServiceDetailActivity extends AppCompatActivity {
    private TextView tvServiceName;
    private TextView tvServicePrice;
    private TextView tvServiceDuration;
    private TextView tvServiceDescription;
    private ImageView imgService;
    private Button btnBookService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        tvServiceName = findViewById(R.id.tv_service_name);
        tvServicePrice = findViewById(R.id.tv_service_price);
        tvServiceDuration = findViewById(R.id.tv_service_duration);
        tvServiceDescription = findViewById(R.id.tv_service_description);
        imgService = findViewById(R.id.img_service);
        btnBookService = findViewById(R.id.btn_book_service);

        Service service = (Service) bundle.get("object_service");

        tvServiceName.setText(service.getServiceName());
        tvServicePrice.setText(String.valueOf(service.getPrice())+"đ");
        tvServiceDuration.setText(service.getDuration());
        tvServiceDescription.setText(service.getDescription());
        imgService.setImageResource(service.getImg());

        btnBookService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
