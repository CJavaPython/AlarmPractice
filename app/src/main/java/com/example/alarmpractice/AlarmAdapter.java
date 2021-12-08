package com.example.alarmpractice;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> implements OnAlarmItemClickListener{

    ArrayList<Alarms> items = new ArrayList<Alarms>();
    OnAlarmItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.alarm_item, viewGroup, false);

        return new ViewHolder(itemView, this);
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


    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;

        TextView alarmTime;

        TextView alarmLabel;

        Switch alarmOnOff;

        public ViewHolder(View itemView, final OnAlarmItemClickListener listener) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);

            alarmTime = itemView.findViewById(R.id.alarmTime);
            alarmLabel = itemView.findViewById(R.id.alarmLabel);


            alarmOnOff = itemView.findViewById(R.id.alarmOnOff);


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
            /*
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

             */
            alarmTime.setText("00:00");
            alarmLabel.setText(item.getAlarmName());

        }


    }

}
