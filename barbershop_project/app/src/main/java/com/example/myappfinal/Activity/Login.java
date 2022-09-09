package com.example.myappfinal.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappfinal.Model.LoginModel;
import com.example.myappfinal.R;
import com.example.myappfinal.View.LoginView;

import java.text.ParseException;

public class Login extends AppCompatActivity implements  View.OnClickListener , LoginView {

    private TextView register;
    private EditText username, password;
    private Button login;

    final LoginModel loginModel=new LoginModel();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginModel.setDB(loginModel.getLoginPresenter().createNewDB(this));
        setID();
        setListener();

    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this, CreateAccount.class));
                //finish();
                break;
            case R.id.login:
                String user=username.getText().toString();
                String pass=password.getText().toString();
                try {
                    checkingLogin(user, pass);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
    }

    private void setID() {
        register= (TextView) findViewById(R.id.register);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login= (Button)  findViewById(R.id.login);
    }
    private void setListener() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    private void checkingLogin(String user, String pass) throws ParseException {
        if(user.equals("")|| pass.equals("")){
            textAllFilledMessage();
        }else{

            loginModel.getLoginPresenter().fillEverything();

            intentForUser(user, pass);
        }
    }


    private void intentForUser(String user, String pass) {
        if(loginModel.getLoginPresenter().isEmployee(user,pass,loginModel)) {
            successfulSignIn();
            Intent intent = new Intent(this, AfterLogin.class);
            intent.putExtra("user", loginModel.getUSER());
            startActivity(intent);
        }
        else if(loginModel.getLoginPresenter().isValidCustomer(user,pass, loginModel)){
            successfulSignIn();
            Intent intent = new Intent(this, AfterLogin.class);
            intent.putExtra("user",loginModel.getUSER());
            startActivity(intent);
        }else {
            invalidCredentials();
        }
    }

    @Override
    public void textAllFilledMessage() {
        Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successfulSignIn() {
        Toast.makeText(this, "Successful Sign In", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void invalidCredentials() {
        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}