package com.example.myappfinal.Controller;

import android.content.Context;

import com.example.myappfinal.Database.DBLoginHelper;
import com.example.myappfinal.Database.DBLoginHelperDAO;

public class CreateAccountController {

    public boolean checkusername(DBLoginHelperDAO DB, String user){
        return DB.checkusername(user);
    }

    public boolean insertData(DBLoginHelperDAO DB, String user, String pass, String fn, String ln, String em, String ph){
       return DB.insertData(user,pass,fn,ln,em,ph);
    }

    public DBLoginHelperDAO createNewDB(Context context){
        return new DBLoginHelper(context);
    }

}
