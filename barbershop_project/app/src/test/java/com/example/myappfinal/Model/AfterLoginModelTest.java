package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class AfterLoginModelTest {

    static AfterLoginModel afterLoginModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        afterLoginModel=new AfterLoginModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        afterLoginModel.setUser(user);
        assertEquals(user,afterLoginModel.getUser());
    }

}