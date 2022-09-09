package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProfileModelTest {

    static ProfileModel profileModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        profileModel=new ProfileModel();
    }

    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        profileModel.setUser(user);
        assertEquals(user,profileModel.getUser());
    }

}