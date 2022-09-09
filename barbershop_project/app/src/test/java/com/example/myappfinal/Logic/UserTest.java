package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll(){
        user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        user.createAnAppointment(1,1,1);
        user.createAnAppointment(1,1,1,"Giannis","Mparous");
    }

    /**
     * Ελέγχει την getUsername
     */
    @Test
    public void getUsername() {
        assertEquals("giannis",user.getUsername());
    }

    /**
     * Ελέγχει την getPassword
     */
    @Test
    public void getPassword() {
        assertEquals("t",user.getPassword());
    }

    /**
     * Ελέγχει την getFirstName
     */
    @Test
    public void getFirstName() {
        assertEquals("Giannis",user.getFirstName());
    }

    /**
     * Ελέγχει την getLastName
     */
    @Test
    public void getLastName() {
        assertEquals("Mparous",user.getLastName());
    }

    /**
     * Ελέγχει την getEmail
     */
    @Test
    public void getEmail() {
        assertEquals("email@gmail.com",user.getEmail());
    }

    /**
     * Ελέγχει την getPhoneNumber
     */
    @Test
    public void getPhoneNumber() {
        assertEquals("6969696969",user.getPhoneNumber());
    }



}