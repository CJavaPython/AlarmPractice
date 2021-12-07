package com.example.alarmpractice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> implements OnAlarmItemClickListener{
    ArrayList<Alarms> items = new ArrayList<Alarms>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        public ViewHolder(View itemView, final OnAlarmItemClickListener listener, int layoutType) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);
        }
    }

}
