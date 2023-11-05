package com.example.prm392_team1_spaapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_team1_spaapp.R;
import com.example.prm392_team1_spaapp.RechargeWithdraw;
import com.example.prm392_team1_spaapp.ServiceDetailActivity;
import com.example.prm392_team1_spaapp.adapter.ServiceAdapter;
import com.example.prm392_team1_spaapp.adapter.my_interface.OnItemClickListener;
import com.example.prm392_team1_spaapp.dataLocal.DataLocalManager;
import com.example.prm392_team1_spaapp.model.Service;
import com.example.prm392_team1_spaapp.model.ServiceDatabase;

import java.util.List;

public class HomeFragment extends Fragment {
    private ImageView img_recharge_withdraw;
    private ImageView img_see_money;
    private TextView tv_money;
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
        serviceAdapter.setData(mServiceList, new OnItemClickListener() {
            @Override
            public void onItemClick(Service selectedService) {
                Intent intent = new Intent(getContext(), ServiceDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_service", selectedService);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rcvService.setAdapter(serviceAdapter);

//        LinearLayout linearLayout = view.findViewById(R.id.bill);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), PayBillActivity.class);
//                startActivity(intent);
//            }
//        });
        img_recharge_withdraw = view.findViewById(R.id.recharge_withdraw);
        img_see_money = view.findViewById(R.id.img_see_money);
        tv_money = view.findViewById(R.id.tv_money);

        img_recharge_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RechargeWithdraw.class);
                startActivity(intent);
            }
        });

        img_see_money.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tv_money.setText(String.valueOf(DataLocalManager.getInstance().getPrefMoney())); // Hiển thị số tiền
                return true; // Trả về true để xác nhận xử lý sự kiện long click
            }
        });

        img_see_money.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    tv_money.setText("Xem số dư");
                }
                return true;
            }

        });
        return view;
    }

}