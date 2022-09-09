package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class HistoryModelTest {

    static HistoryModel historyModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        historyModel=new HistoryModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        historyModel.setUser(user);
        assertEquals(user,historyModel.getUser());
    }

    /**
     * Ελέγχει τις setAppointments και getAppointments
     */
    @Test
    public void setAndGetAppointments() {
        ArrayList<Appointment> appointments=new ArrayList<Appointment>();
        historyModel.setAppointments(appointments);
        assertEquals(appointments,historyModel.getAppointments());
    }

}