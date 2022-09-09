package com.example.myappfinal.Model;

import com.example.myappfinal.Controller.LoginController;
import com.example.myappfinal.Database.DBLoginHelperDAO;
import com.example.myappfinal.Logic.User;

public class LoginModel {

    public DBLoginHelperDAO DB;
    private User USER;
    private final LoginController loginPresenter;

    public LoginModel(){
        loginPresenter=new LoginController();
    }

    public void setDB(DBLoginHelperDAO DB){
        this.DB=DB;
    };

    public DBLoginHelperDAO getDB() {
        return DB;
    }

    public User getUSER() {
        return USER;
    }

    public void setUSER(User USER) {
        this.USER = USER;
    }

    public LoginController getLoginPresenter(){
        return loginPresenter;
    }
}
