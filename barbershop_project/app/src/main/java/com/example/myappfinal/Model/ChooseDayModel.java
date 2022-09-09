package com.example.myappfinal.Model;

import com.example.myappfinal.Logic.User;

public class ChooseDayModel {

    private User user;
    private int service,day;

    public void setUser(User user){
        this.user=user;
    }

    public void setService(int service){
        this.service=service;
    }

    public void setDay(int day){
        this.day=day;
    }

    public int getDay(){
        return day;
    }

    public int getService(){
        return service;
    }

    public User getUser(){
        return user;
    }
}
