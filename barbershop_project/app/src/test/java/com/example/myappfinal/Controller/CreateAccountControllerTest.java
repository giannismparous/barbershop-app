package com.example.myappfinal.Controller;

import static org.junit.Assert.*;

import com.example.myappfinal.Database.LocalDatabase;

import org.junit.Before;
import org.junit.Test;

public class CreateAccountControllerTest {

    public CreateAccountController createAccountController;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll(){
       createAccountController=new CreateAccountController();
    }

    /**
     * Ελέγχει την checkusername
     */
    @Test
    public void checkusername() {
        LocalDatabase DB=new LocalDatabase();
        assertFalse(createAccountController.checkusername(DB,"A"));
        DB.insertData("A","B","C","D","E","F");
        assertTrue(createAccountController.checkusername(DB,"A"));
    }

    /**
     * Ελέγχει την insertData
     */
    @Test
    public void insertData() {
        LocalDatabase DB=new LocalDatabase();
        assertFalse(createAccountController.checkusername(DB,"A"));
        createAccountController.insertData(DB,"A","B","C","D","E","F");
        assertTrue(createAccountController.checkusername(DB,"A"));
    }

    /**
     * Ελέγχει την createNewDB
     */
    @Test
    public void createNewDB() {
        assertNotNull(createAccountController.createNewDB(null));
    }
}