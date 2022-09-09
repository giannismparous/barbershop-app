package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myappfinal.Model.ProfileModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;

import java.io.Serializable;

public class Profile extends AppCompatActivity implements  View.OnClickListener, Serializable {

    private TextView username,firstName,lastName,phone,email,gender;
    private Button back;
    private final ProfileModel profileModel=new ProfileModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        setID();
        infoFromPreviousActivity();
        setInfo();
        setListener();

    }

    @Override

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back:
                finish();
        }

    }

    private void infoFromPreviousActivity() {
        profileModel.setUser((User) getIntent().getSerializableExtra("user"));
    }

    private void setListener() {
        back.setOnClickListener(this);
    }

    private void setID(){
        username = (TextView) findViewById(R.id.usernameInfo);
        firstName = (TextView) findViewById(R.id.firstNameInfo);
        lastName = (TextView) findViewById(R.id.lastNameInfo);
        phone = (TextView) findViewById(R.id.phoneInfo);
        email = (TextView) findViewById(R.id.emailInfo);
        gender = (TextView) findViewById(R.id.genderInfo);
        back= (Button)  findViewById(R.id.back);
    }

    private void setInfo(){
        username.setText(profileModel.getUser().getUsername());
        firstName.setText(profileModel.getUser().getFirstName());
        lastName.setText(profileModel.getUser().getLastName());
        phone.setText(profileModel.getUser().getPhoneNumber());
        email.setText(profileModel.getUser().getEmail());
        gender.setText("A");
    }

}