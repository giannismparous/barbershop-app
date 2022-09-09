package com.example.myappfinal.Controller;

import android.content.Context;

import com.example.myappfinal.Database.DBLoginHelper;
import com.example.myappfinal.Database.DBLoginHelperDAO;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.DateAppointment;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Model.LoginModel;
import com.example.myappfinal.Logic.Service;
import com.example.myappfinal.Logic.TimeAppointment;

import java.text.ParseException;

public class LoginController {

    private static boolean isFilled=true;

    public boolean isEmployee(String user, String pass, LoginModel loginModel) {
        if(user.equals("M")||pass.equals("M")){
            String b ="BOSS";
            loginModel.setUSER(new Employee(b,b,b,b,b,b));
            return true;
        }
        return false;
    }

    public boolean isValidCustomer(String user, String pass, LoginModel loginModel){
        Boolean check=loginModel.DB.checkUsernamePassword(user, pass);
        if(check){
            if (Customer.getCustomer(user)==null) {
                loginModel.setUSER(new Customer(user, pass, loginModel.DB.takeFirstName(user), loginModel.DB.takeLastName(user),loginModel.DB.takeEmail(user),loginModel.DB.takePhone(user),'A'));
            }
            else {
                loginModel.setUSER(Customer.getCustomer(user));
            }
        }
        return check;
    }

    public void fillEverything() throws ParseException {
        if(isFilled) {
            isFilled=false;
            fillTime();
            Service.addServices();
            fillDates();
        }
    }
    private void fillTime() throws ParseException {
        TimeAppointment.addTimes();
    }

    private void fillDates() throws ParseException {
        DateAppointment.addDates();
    }

    public DBLoginHelperDAO createNewDB(Context context){
        return new DBLoginHelper(context);
    }

}
