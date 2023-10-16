package com.example.prm392_team1_spaapp.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_team1_spaapp.R;
import com.example.prm392_team1_spaapp.adapter.ListHistoryAdapter;
import com.example.prm392_team1_spaapp.model.History;

import java.util.ArrayList;
import java.util.List;


public class Promotion extends Fragment {
    private static final String TABLE_NAME = "bank_trans";
    private RecyclerView recyclerView;
    private ListHistoryAdapter adapter;
    private ArrayList<History> listHistory = new ArrayList<History>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_list, container, false);

        listHistory.add(new History(1,1,"Promotion 1","12/12/2023",12000,1,"moa moa moa"));
        listHistory.add(new History(2,1,"Promotion 2","30/5/2024",100000,0,"moa moa moa"));
        listHistory.add(new History(3,1,"Promotion 3","30/4/2024",562000,1,"moa moa moa"));
        listHistory.add(new History(4,1,"Promotion 4","30/10/2024",123000,0,"moa moa moa"));
        listHistory.add(new History(5,1,"Promotion 5","30/11/2024",52300,1,"moa moa moa"));
        listHistory.add(new History(6,1,"Promotion 6","30/12/2024",33000,1,"moa moa moa"));
        recyclerView = view.findViewById(R.id.rcv_cate_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        adapter = new ListHistoryAdapter(listHistory);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
