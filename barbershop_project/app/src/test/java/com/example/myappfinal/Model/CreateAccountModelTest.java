package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Database.DBLoginHelperDAO;
import com.example.myappfinal.Database.LocalDatabase;

import org.junit.BeforeClass;
import org.junit.Test;

public class CreateAccountModelTest {

    static CreateAccountModel createAccountModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        createAccountModel=new CreateAccountModel();
    }

    /**
     * Ελέγχει τις setDB και getDB
     */
    @Test
    public void setAndGetDB() {
        DBLoginHelperDAO DB=new LocalDatabase();
        createAccountModel.setDB(DB);
        assertEquals(DB,createAccountModel.getDB());
    }

    /**
     * Ελέγχει την getCreateAccountPresenter
     */
    @Test
    public void getCreateAccountPresenter() {
        assertNotNull(createAccountModel.getCreateAccountPresenter());
    }
}