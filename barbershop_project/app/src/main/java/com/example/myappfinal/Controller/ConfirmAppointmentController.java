package com.example.myappfinal.Controller;

import com.example.myappfinal.Logic.User;

public class ConfirmAppointmentController {

    public void createAnAppointment(User user, int service, int day, int time){
        user.createAnAppointment(service,day,time);
    }

    public void createAnAppointment(User user, int service,int day,int time,String name,String phone){
        user.createAnAppointment(service, day, time, name, phone);
    }

}
