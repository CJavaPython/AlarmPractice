package com.example.alarmpractice;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> implements OnAlarmItemClickListener{

    ArrayList<Alarms> items = new ArrayList<Alarms>();
    OnAlarmItemClickListener listener;
    int layoutType = 0;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.alarm_item, viewGroup, false);

        return new ViewHolder(itemView, this, layoutType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Alarms item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Alarms item) {
        items.add(item);
    }

    public void setItems(ArrayList<Alarms> items) {
        this.items = items;
    }

    public Alarms getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnAlarmItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void switchLayout(int position) {
        layoutType = position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;

        TimePicker edit_alarm_time_picker;

        EditText edit_alarm_label;

        CheckBox edit_alarm_mon;
        CheckBox edit_alarm_tue;
        CheckBox edit_alarm_wed;
        CheckBox edit_alarm_thu;
        CheckBox edit_alarm_fri;
        CheckBox edit_alarm_sat;
        CheckBox edit_alarm_sun;

        public ViewHolder(View itemView, final OnAlarmItemClickListener listener, int layoutType) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);

            edit_alarm_time_picker = itemView.findViewById(R.id.edit_alarm_time_picker);


            edit_alarm_label = itemView.findViewById(R.id.edit_alarm_label);

            edit_alarm_mon = itemView.findViewById(R.id.edit_alarm_mon);
            edit_alarm_tue = itemView.findViewById(R.id.edit_alarm_tue);
            edit_alarm_wed = itemView.findViewById(R.id.edit_alarm_wed);
            edit_alarm_thu = itemView.findViewById(R.id.edit_alarm_thu);
            edit_alarm_fri = itemView.findViewById(R.id.edit_alarm_fri);
            edit_alarm_sat = itemView.findViewById(R.id.edit_alarm_sat);
            edit_alarm_sun = itemView.findViewById(R.id.edit_alarm_sun);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Alarms item) {
            //time picker setting
            final Calendar c = Calendar.getInstance();
            c.setTimeInMillis(item.getTime());

            final int minutes = c.get(Calendar.MINUTE);
            final int hours = c.get(Calendar.HOUR_OF_DAY);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit_alarm_time_picker.setMinute(minutes);
                edit_alarm_time_picker.setHour(hours);
            } else {
                edit_alarm_time_picker.setCurrentMinute(minutes);
                edit_alarm_time_picker.setCurrentHour(hours);
            }

            edit_alarm_label.setText(item.getAlarmName());
        }


    }

}
