package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChooseServiceModelTest {

    static ChooseServiceModel chooseServiceModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        chooseServiceModel=new ChooseServiceModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        chooseServiceModel.setUser(user);
        assertEquals(user,chooseServiceModel.getUser());
    }

    /**
     * Ελέγχει τις setService και getService
     */
    @Test
    public void setAndGetService() {
        int service=1;
        chooseServiceModel.setService(service);
        assertEquals(service,chooseServiceModel.getService());
    }
}