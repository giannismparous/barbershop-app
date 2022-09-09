package com.example.myappfinal.Model;

import com.example.myappfinal.Controller.CreateAccountController;
import com.example.myappfinal.Database.DBLoginHelperDAO;

public class CreateAccountModel {

    private DBLoginHelperDAO DB;
    private final CreateAccountController createAccountController;

    public CreateAccountModel(){
        createAccountController=new CreateAccountController();
    }

    public void setDB(DBLoginHelperDAO DB){
        this.DB=DB;
    }

    public DBLoginHelperDAO getDB(){
        return DB;
    }

    public CreateAccountController getCreateAccountPresenter(){
        return createAccountController;
    }

}
