package com.example.myappfinal.Controller;

import static org.junit.Assert.*;

import com.example.myappfinal.Database.LocalDatabase;
import com.example.myappfinal.Model.LoginModel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

public class LoginControllerTest {

    LoginController loginController;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll() throws ParseException {
        loginController=new LoginController();
        loginController.fillEverything();
    }

    /**
     * Ελέγχει την isEmployee
     */
    @Test
    public void isEmployee() {
        LoginModel loginModel=new LoginModel();
        assertFalse(loginController.isEmployee("k","k",loginModel));
        assertTrue(loginController.isEmployee("M","M",loginModel));
    }

    /**
     * Ελέγχει την isValidCustomer
     */
    @Test
    public void isValidCustomer() {
        LoginModel loginModel=new LoginModel();
        LocalDatabase DB=new LocalDatabase();
        DB.insertData("G","G","G","G","G","G");
        loginModel.setDB(DB);
        assertFalse(loginController.isValidCustomer("k","k",loginModel));
        assertTrue(loginController.isValidCustomer("G","G",loginModel));
        assertTrue(loginController.isValidCustomer("G","G",loginModel));
    }

    /**
     * Ελέγχει την createNewDB
     */
    @Test
    public void createNewDB(){
        assertNotNull(loginController.createNewDB(null));
    }

}