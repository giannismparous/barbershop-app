package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Database.LocalDatabase;
import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginModelTest {

    static LoginModel loginModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        loginModel = new LoginModel();
    }

    /**
     * Ελέγχει τις setDB και getDB
     */
    @Test
    public void setAndGetDB() {
        LocalDatabase DB=new LocalDatabase();
        loginModel.setDB(DB);
        assertEquals(DB,loginModel.getDB());
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        loginModel.setUSER(user);
        assertEquals(user,loginModel.getUSER());
    }

    /**
     * Ελέγχει την getLoginPresenter
     */
    @Test
    public void getLoginPresenter() {
        assertNotNull(loginModel.getLoginPresenter());
    }
}