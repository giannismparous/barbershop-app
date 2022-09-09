package com.example.myappfinal.Model;

import com.example.myappfinal.Logic.User;

public class AfterLoginModel {

    private User user;

    public AfterLoginModel(){
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}
