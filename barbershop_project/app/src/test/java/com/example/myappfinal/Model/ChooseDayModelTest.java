package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChooseDayModelTest {

    static ChooseDayModel chooseDayModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        chooseDayModel=new ChooseDayModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        chooseDayModel.setUser(user);
        assertEquals(user,chooseDayModel.getUser());
    }

    /**
     * Ελέγχει τις setService και getService
     */
    @Test
    public void setAndGetService() {
        int service=1;
        chooseDayModel.setService(service);
        assertEquals(service,chooseDayModel.getService());
    }

    /**
     * Ελέγχει τις setDay και getDay
     */
    @Test
    public void setAndGetDay() {
        int day=3;
        chooseDayModel.setDay(day);
        assertEquals(day,chooseDayModel.getDay());
    }

}