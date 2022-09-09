package com.example.myappfinal.Model;

import com.example.myappfinal.Controller.ConfirmAppointmentController;
import com.example.myappfinal.Logic.User;

public class ConfirmAppointmentModel {

    private User user;
    private int service;
    private int day;
    private int time;
    private String name="";
    private String phone="";
    private final ConfirmAppointmentController confirmAppointmentController;

    public ConfirmAppointmentModel(){
        confirmAppointmentController=new ConfirmAppointmentController();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ConfirmAppointmentController getConfirmAppointmentPresenter(){
        return confirmAppointmentController;
    }
}
