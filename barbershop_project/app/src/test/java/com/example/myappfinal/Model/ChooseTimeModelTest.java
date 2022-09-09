package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChooseTimeModelTest {

    static ChooseTimeModel chooseTimeModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        chooseTimeModel=new ChooseTimeModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        chooseTimeModel.setUser(user);
        assertEquals(user,chooseTimeModel.getUser());
    }

    /**
     * Ελέγχει τις setService και getService
     */
    @Test
    public void setAndGetService() {
        int service=1;
        chooseTimeModel.setService(service);
        assertEquals(service,chooseTimeModel.getService());
    }

    /**
     * Ελέγχει τις setDay και getDay
     */
    @Test
    public void setAndGetDay() {
        int day=3;
        chooseTimeModel.setDay(day);
        assertEquals(day,chooseTimeModel.getDay());
    }

    /**
     * Ελέγχει τις setTime και getTime
     */
    @Test
    public void setAndGetTime() {
        int time=5;
        chooseTimeModel.setTime(5);
        assertEquals(5,chooseTimeModel.getTime());
    }

}