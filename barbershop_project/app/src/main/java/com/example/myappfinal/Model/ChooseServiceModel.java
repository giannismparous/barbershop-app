package com.example.myappfinal.Model;

import com.example.myappfinal.Logic.User;

public class ChooseServiceModel {

    private int service;
    private User user;

    public void setUser(User user){
        this.user=user;
    }

    public void setService(int service){
        this.service=service;
    }

    public int getService(){
        return service;
    }

    public User getUser(){
        return user;
    }

}
