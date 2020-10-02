package com.example.AlphaHealthAssistant.ui.wreminder;

import java.time.LocalDate;
import java.time.LocalTime;

public class WaterReminder {

    private Integer wAmount;
    private String addDate;
    private String addTime;

    public WaterReminder(){
    }
    public WaterReminder(Integer wAmount, String addDate, String addTime) {
        this.wAmount = wAmount;
        this.addDate = addDate;
        this.addTime = addTime;
    }

    public Integer getwAmount() {
        return wAmount;
    }

    public void setwAmount(Integer wAmount) {
        this.wAmount = wAmount;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
