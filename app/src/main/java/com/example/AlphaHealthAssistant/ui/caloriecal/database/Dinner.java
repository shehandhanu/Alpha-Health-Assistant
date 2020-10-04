package com.example.AlphaHealthAssistant.ui.caloriecal.database;

public class Dinner {
    private Integer breadCount;
    private Integer noodlesCount;
    private Integer coconutRotiCount;
    private String date;


    public Dinner() {
    }

    public Integer getBreadCount() {
        return breadCount;
    }

    public void setBreadCount(Integer breadCount) {
        this.breadCount = breadCount;
    }

    public Integer getNoodlesCount() {
        return noodlesCount;
    }

    public void setNoodlesCount(Integer noodlesCount) {
        this.noodlesCount = noodlesCount;
    }

    public Integer getCoconutRotiCount() {
        return coconutRotiCount;
    }

    public void setCoconutRotiCount(Integer coconutRotiCount) {
        this.coconutRotiCount = coconutRotiCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
