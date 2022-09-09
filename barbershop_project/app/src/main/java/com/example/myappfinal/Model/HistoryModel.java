package com.example.myappfinal.Model;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.User;

import java.util.ArrayList;

public class HistoryModel {

    private User user;
    private ArrayList<Appointment> appointments;

    public void setUser(User user){
        this.user=user;
    }

    public User getUser(){
        return user;
    }

    public void setAppointments(ArrayList<Appointment> appointments){
        this.appointments=appointments;
    }

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }

}
