package com.example.alarmpractice;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    Context context;
    onTabItemSelectedListener listener;
    int mMode = AppConstants.MODE_INSERT;
    int _id=-1;
    int alarmIndex=0;

    Alarms item;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof onTabItemSelectedListener) {
            listener = (onTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context == null) {
            context = null;
            listener = null;
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        Button saveAlarmButton = rootView.findViewById(R.id.saveAlarmButton);
        saveAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener == null) {
                    listener.onTabSelected(0);
                }

                SharedPreferences sharedPreferences = context.getSharedPreferences("daily alarm", MODE_PRIVATE);
                long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());

                Calendar nextNotifyTime = new GregorianCalendar();
                nextNotifyTime.setTimeInMillis(millis);


            }
        });
        Button deleteAlarmButton = rootView.findViewById(R.id.deleteAlarmButton);
        deleteAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener == null) {
                    listener.onTabSelected(0);
                }

            }
        });

        //time picker setting
        TimePicker edit_alarm_time_picker = (TimePicker) rootView.findViewById(R.id.edit_alarm_time_picker);

        edit_alarm_time_picker.setIs24HourView(true);
        //앞서 설정한 값으로 보여주기
        //없으면 디폴트 값은 현재 시간
        SharedPreferences sharedPreferences = context.getSharedPreferences("daily alarm", MODE_PRIVATE);
        long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());

        Calendar nextNotifyTime = new GregorianCalendar();
        nextNotifyTime.setTimeInMillis(millis);

        Date nextDate = nextNotifyTime.getTime();
        String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(nextDate);


        // 이전 설정값으로 Timepicker 초기화
        Date currentTime = nextNotifyTime.getTime();
        SimpleDateFormat HourFormat = new SimpleDateFormat("kk", Locale.getDefault());
        SimpleDateFormat MinuteFormat = new SimpleDateFormat("mm", Locale.getDefault());

        int pre_hour = Integer.parseInt(HourFormat.format(currentTime));
        int pre_minute = Integer.parseInt(MinuteFormat.format(currentTime));


        if (Build.VERSION.SDK_INT >= 23 ){
            edit_alarm_time_picker.setHour(pre_hour);
            edit_alarm_time_picker.setMinute(pre_minute);
        }
        else{
            edit_alarm_time_picker.setCurrentHour(pre_hour);
            edit_alarm_time_picker.setCurrentMinute(pre_minute);
        }


    }

    public void setItem(Alarms item) {
        this.item = item;
    }
}