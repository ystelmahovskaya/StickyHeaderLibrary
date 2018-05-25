package com.example.yuliiastelmakhovska.stickyheaderlibrary.Models;

import android.graphics.Color;

import java.util.Date;

/**
 * Created by ystelmak on 2018-04-25.
 */

public class Trip {
    private int code;
    private Date date;
    private String country;
    private double expenses;
    private int color;

    public Trip(int code,Date date,String country,double expenses,int color){
        this.code = code;
        this.date = date;
        this.country = country;
        this.expenses = expenses;
        this.color = color;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
