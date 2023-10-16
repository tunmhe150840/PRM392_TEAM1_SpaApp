package com.example.prm392_team1_spaapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_team1_spaapp.R;
import com.example.prm392_team1_spaapp.model.History;

import java.util.List;


public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.ListViewHolder>{


    private List<History> listHistory;

    public ListHistoryAdapter(List<History> data) {
        this.listHistory = data;
    }


    public void setData(List<History> list){
        this.listHistory = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_history_item, parent, false);
        return  new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        History history = listHistory.get(position);
        if (history==null){
            return;
        }
        holder.tv_name.setText(history.getTransactionType());
        holder.tv_date.setText(history.getTransactionTime());
        holder.description.setText(history.getDescription());
        holder.money.setText(Integer.toString(history.getAmount()));
        holder.status.setText(history.getStatus()==1? "Thành công" : "Thất bại");
        int colorRes = history.getStatus() == 1 ? R.color.green : R.color.red;
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorRes);
        holder.status.setTextColor(color);

    }

    @Override
    public int getItemCount() {
        if(listHistory!=null){
            return listHistory.size();
        }
        return 0;
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_date;
        private TextView description;
        private TextView money;
        private TextView status;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_namee);
            tv_date = itemView.findViewById(R.id.tv_date);
            description = itemView.findViewById(R.id.description);
            money = itemView.findViewById(R.id.money);
            status = itemView.findViewById(R.id.status);
        }
    }
}
