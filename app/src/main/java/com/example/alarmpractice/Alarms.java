package com.example.alarmpractice;

public class Alarms {

    int id; String alarmName;
    boolean MonRepeat;
    boolean TueRepeat;
    boolean WedRepeat;
    boolean ThuRepeat;
    boolean FriRepeat;
    boolean SatRepeat;
    boolean SunRepeat;
    long time;
    int hour;
    int minutes;

    public Alarms(int id, String alarmName, boolean monRepeat, boolean tueRepeat, boolean wedRepeat, boolean thuRepeat, boolean friRepeat, boolean satRepeat, boolean sunRepeat, long time, int hour, int minutes) {
        this.id = id;
        this.time = time;
        this.alarmName = alarmName;
        MonRepeat = monRepeat;
        TueRepeat = tueRepeat;
        WedRepeat = wedRepeat;
        ThuRepeat = thuRepeat;
        FriRepeat = friRepeat;
        SatRepeat = satRepeat;
        SunRepeat = sunRepeat;
        this.time = time;
        this.hour = hour;
        this.minutes = minutes;
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

    public boolean isMonRepeat() {
        return MonRepeat;
    }

    public void setMonRepeat(boolean monRepeat) {
        MonRepeat = monRepeat;
    }

    public boolean isTueRepeat() {
        return TueRepeat;
    }

    public void setTueRepeat(boolean tueRepeat) {
        TueRepeat = tueRepeat;
    }

    public boolean isWedRepeat() {
        return WedRepeat;
    }

    public void setWedRepeat(boolean wedRepeat) {
        WedRepeat = wedRepeat;
    }

    public boolean isThuRepeat() {
        return ThuRepeat;
    }

    public void setThuRepeat(boolean thuRepeat) {
        ThuRepeat = thuRepeat;
    }

    public boolean isFriRepeat() {
        return FriRepeat;
    }

    public void setFriRepeat(boolean friRepeat) {
        FriRepeat = friRepeat;
    }

    public boolean isSatRepeat() {
        return SatRepeat;
    }

    public void setSatRepeat(boolean satRepeat) {
        SatRepeat = satRepeat;
    }

    public boolean isSunRepeat() {
        return SunRepeat;
    }

    public void setSunRepeat(boolean sunRepeat) {
        SunRepeat = sunRepeat;
    }
    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
