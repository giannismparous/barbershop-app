package com.example.myappfinal.Activity;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Model.AfterLoginModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;

import java.io.Serializable;

public class AfterLogin extends AppCompatActivity implements  View.OnClickListener, Serializable {

    private Button myProfile,appointment,history,button4,exit;
    private final AfterLoginModel afterLoginModel=new AfterLoginModel();


    public static final int REQUEST_CODE=1014;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin);

        setID();
        infoFromPreviousActivity();
        setListener();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.myProfile:
                intentProfile();
                break;
            case R.id.appointment:
                intentForMakingAnAppointment();
                break;
            case R.id.history:
                intentForViewHistory();
                break;
            case R.id.button4:
                if(afterLoginModel.getUser() instanceof Customer) {
                    Intent intent3 = new Intent(this, Evaluate.class);
                    intent3.putExtra("user", afterLoginModel.getUser());
                    startActivity(intent3);
                }else{
                    startActivity(new Intent(this, Statistics.class));
                }
                break;
            case R.id.exit:
                finish();

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK)
                    afterLoginModel.setUser((User) data.getSerializableExtra("user"));
        }
    }


    private void setID() {
        myProfile= (Button)  findViewById(R.id.myProfile);
        appointment = (Button)  findViewById(R.id.appointment);
        history= (Button)  findViewById(R.id.history);
        button4= (Button)  findViewById(R.id.button4);
        exit= (Button)  findViewById(R.id.exit);
    }
    private void infoFromPreviousActivity() {
        afterLoginModel.setUser((User) getIntent().getSerializableExtra("user"));
    }
    private void setListener() {
        myProfile.setOnClickListener(this);

        appointment.setOnClickListener(this);

        if(afterLoginModel.getUser() instanceof Employee) {
            button4.setText("Statistics");
        }
        button4.setOnClickListener(this);
        history.setOnClickListener(this);
        exit.setOnClickListener(this);
    }


    //New Intents method
    private void intentForViewHistory() {
        Intent intent3=new Intent(this, History.class);
        intent3.putExtra("user",afterLoginModel.getUser());
        startActivity(intent3);
        return;
    }
    private void intentForMakingAnAppointment() {
        Intent intent2=new Intent(this, ChooseService.class);
        intent2.putExtra("user",afterLoginModel.getUser());
        startActivityForResult(intent2,REQUEST_CODE);
        return;
    }
    private void intentProfile() {
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("user",afterLoginModel.getUser());
        startActivity(intent);
        return;
    }
}