package com.example.AlphaHealthAssistant.ui.bmi;

import com.google.firebase.Timestamp;

public class BMIModel {
    private String docId;
    private int age;
    private double weight;
    private double height;
    private double bmi;
    private Timestamp date;

    public BMIModel(){

    }

    public BMIModel(int age, double weight, double height, double bmi, Timestamp date) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}
