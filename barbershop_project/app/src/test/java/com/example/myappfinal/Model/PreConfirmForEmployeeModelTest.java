package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class PreConfirmForEmployeeModelTest {

    static PreConfirmForEmployeeModel preConfirmForEmployeeModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        preConfirmForEmployeeModel=new PreConfirmForEmployeeModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        preConfirmForEmployeeModel.setUser(user);
        assertEquals(user,preConfirmForEmployeeModel.getUser());
    }

    /**
     * Ελέγχει τις setService και getService
     */
    @Test
    public void setAndGetService() {
        int service=1;
        preConfirmForEmployeeModel.setService(service);
        assertEquals(service,preConfirmForEmployeeModel.getService());
    }

    /**
     * Ελέγχει τις setDay και getDay
     */
    @Test
    public void setAndGetDay() {
        int day=3;
        preConfirmForEmployeeModel.setDay(day);
        assertEquals(day,preConfirmForEmployeeModel.getDay());
    }

    /**
     * Ελέγχει τις setTime και getTime
     */
    @Test
    public void setAndGetTime() {
        int time=5;
        preConfirmForEmployeeModel.setTime(5);
        assertEquals(5,preConfirmForEmployeeModel.getTime());
    }

    /**
     * Ελέγχει τις setName και getName
     */
    @Test
    public void setAndGetName() {
        String name="A";
        preConfirmForEmployeeModel.setName(name);
        assertEquals(name,preConfirmForEmployeeModel.getName());
    }

    /**
     * Ελέγχει τις setPhone και getPhone
     */
    @Test
    public void setAndGetPhone() {
        String phone="5";
        preConfirmForEmployeeModel.setPhone(phone);
        assertEquals(phone,preConfirmForEmployeeModel.getPhone());
    }

}