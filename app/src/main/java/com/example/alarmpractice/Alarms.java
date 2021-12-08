package com.example.alarmpractice;

public class Alarms {

    int id; String alarmName;
    long time;

    public Alarms(int id, String alarmName, long time) {
        this.id = id;
        this.time = time;
        this.alarmName = alarmName;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
