package com.example.prm392_team1_spaapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_team1_spaapp.R;
import com.example.prm392_team1_spaapp.RechargeWithdraw;
import com.example.prm392_team1_spaapp.adapter.ServiceAdapter;
import com.example.prm392_team1_spaapp.model.Service;
import com.example.prm392_team1_spaapp.model.ServiceDatabase;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rcvService;
    private List<Service> mServiceList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        mServiceList = ServiceDatabase.getInstance(getContext()).getServiceDAO().getAllService();
        Log.d("TAG", "onCreate: "+mServiceList.get(1).getServiceName());
        rcvService = view.findViewById(R.id.rcv_service);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4); // 2 cột trong lưới
        rcvService.setLayoutManager(layoutManager);
        ServiceAdapter serviceAdapter = new ServiceAdapter(); // Thay yourDataList bằng danh sách dữ liệu của bạn
        serviceAdapter.setData(mServiceList);
        rcvService.setAdapter(serviceAdapter);

        LinearLayout linearLayout = view.findViewById(R.id.bill);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), PayBillActivity.class);
//                startActivity(intent);
//            }
//        });


        ImageView imageView2 = view.findViewById(R.id.recharge_withdraw);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RechargeWithdraw.class);
                startActivity(intent);
            }
        });

        return view;
    }

}