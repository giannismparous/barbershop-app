package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Model.ChooseTimeModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;
import com.example.myappfinal.View.ChooseView;

import java.io.Serializable;

public class ChooseTime extends AppCompatActivity implements Serializable, View.OnClickListener, ChooseView {


    private Button eight,eightAnd,nine,nineAnd,ten,tenAnd,eleven,elevenAnd,twelve,back;
    private Button twelveAnd,thirteen,thirteenAnd,fourteen,fourteenAnd,fifteen,fifteenAnd;
    private final ChooseTimeModel chooseTimeModel=new ChooseTimeModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);

        infoFromPreviousActivity();
        fillButtons();
        ButtonReact();

    }

    private void infoFromPreviousActivity() {
        chooseTimeModel.setUser((User) getIntent().getSerializableExtra("user"));
        chooseTimeModel.setService((Integer) getIntent().getSerializableExtra("service"));
        chooseTimeModel.setDay((Integer) getIntent().getSerializableExtra("day"));
    }

    private void ButtonReact() {
        if(Appointment.isFree(chooseTimeModel.getDay(),1))
            eight.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),2))
            eightAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),3))
            nine.setOnClickListener(this);
        if(Appointment.isFree(chooseTimeModel.getDay(),4))
            nineAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),5))
            ten.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),6))
            tenAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),7))
            eleven.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),8))
            elevenAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),9))
            twelve.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),10))
            twelveAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),11))
            thirteen.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),12))
            thirteenAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),13))
            fourteen.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),14))
            fourteenAnd.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),15))
            fifteen.setOnClickListener(this);

        if(Appointment.isFree(chooseTimeModel.getDay(),16))
            fifteenAnd.setOnClickListener(this);

        back.setOnClickListener(this);
    }

    private void fillButtons() {


        eight=(Button) findViewById(R.id.eight) ;
        changeBackgroundColor(chooseTimeModel.getDay(),1,eight);


        eightAnd=(Button) findViewById(R.id.eightAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),2,eightAnd);

        nine=(Button) findViewById(R.id.nine) ;
        changeBackgroundColor(chooseTimeModel.getDay(),3,nine);


        nineAnd=(Button) findViewById(R.id.nineAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),4,nineAnd);

        ten=(Button) findViewById(R.id.ten) ;
        changeBackgroundColor(chooseTimeModel.getDay(),5,ten);


        tenAnd=(Button) findViewById(R.id.tenAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),6,tenAnd);


        eleven=(Button) findViewById(R.id.eleven) ;
        changeBackgroundColor(chooseTimeModel.getDay(),7,eleven);


        elevenAnd=(Button) findViewById(R.id.elevenAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),8,elevenAnd);


        twelve=(Button) findViewById(R.id.twelve) ;
        changeBackgroundColor(chooseTimeModel.getDay(),9,twelve);

        twelveAnd=(Button) findViewById(R.id.twelveAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),10,twelveAnd);


        thirteen=(Button) findViewById(R.id.thirteen) ;
        changeBackgroundColor(chooseTimeModel.getDay(),11,thirteen);


        thirteenAnd=(Button) findViewById(R.id.thirteenAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),12,thirteenAnd);


        fourteen=(Button) findViewById(R.id.fourteen) ;
        changeBackgroundColor(chooseTimeModel.getDay(),13,fourteen);

        fourteenAnd=(Button) findViewById(R.id.fourteenAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),14,fourteenAnd);

        fifteen=(Button) findViewById(R.id.fifteen) ;
        changeBackgroundColor(chooseTimeModel.getDay(),15,fifteen);


        fifteenAnd=(Button) findViewById(R.id.fifteenAnd) ;
        changeBackgroundColor(chooseTimeModel.getDay(),16,fifteenAnd);

        back=(Button)findViewById(R.id.back);
    }



    private void changeBackgroundColor(int day , int value , Button b){
        if(!Appointment.isFree(day,value)){
            Drawable buttonDrawable = b.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.BLACK);
            b.setBackground(buttonDrawable);
        }
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back:
                intentForBack();
                break;
            default:
                choose(v);
                if(chooseTimeModel.getUser() instanceof Employee)
                    intentForPreConfirmAppointment();
                else
                    intentForConfirmAppointment();
        }
    }

    public void choose(View v){
        switch (v.getId()){
            case R.id.eight:
                chooseTimeModel.setTime(1);
                break;
            case R.id.eightAnd:
                chooseTimeModel.setTime(2);
                break;
            case R.id.nine:
                chooseTimeModel.setTime(3);
                break;
            case R.id.nineAnd:
                chooseTimeModel.setTime(4);
                break;
            case R.id.ten:
                chooseTimeModel.setTime(5);
                break;
            case R.id.tenAnd:
                chooseTimeModel.setTime(6);
                break;
            case R.id.eleven:
                chooseTimeModel.setTime(7);
                break;
            case R.id.elevenAnd:
                chooseTimeModel.setTime(8);
                break;
            case R.id.twelve:
                chooseTimeModel.setTime(9);
                break;
            case R.id.twelveAnd:
                chooseTimeModel.setTime(10);
                break;
            case R.id.thirteen:
                chooseTimeModel.setTime(11);
                break;
            case R.id.thirteenAnd:
                chooseTimeModel.setTime(12);
                break;
            case R.id.fourteen:
                chooseTimeModel.setTime(13);
                break;
            case R.id.fourteenAnd:
                chooseTimeModel.setTime(14);
                break;
            case R.id.fifteen:
                chooseTimeModel.setTime(15);
                break;
            case R.id.fifteenAnd:
                chooseTimeModel.setTime(16);
                break;
        }

    }

    //New Intents method
    private void intentForBack() {
        Intent intent2= new Intent(this, ChooseDay.class);
        intent2.putExtra("user",chooseTimeModel.getUser());
        intent2.putExtra("service",chooseTimeModel.getService());
        startActivity(intent2);
        finish();
        return;
    }
    private void intentForPreConfirmAppointment() {
        Intent intent = new Intent(this, PreConfirmForEmployee.class);
        intent.putExtra("time",chooseTimeModel.getTime());
        intent.putExtra("day",chooseTimeModel.getDay());
        intent.putExtra("user",chooseTimeModel.getUser());
        intent.putExtra("service",chooseTimeModel.getService());
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
        return;
    }
    private void intentForConfirmAppointment() {
        Intent intent = new Intent(this, ConfirmAppointment.class);
        intent.putExtra("time", chooseTimeModel.getTime());
        intent.putExtra("day", chooseTimeModel.getDay());
        intent.putExtra("user", chooseTimeModel.getUser());
        intent.putExtra("service", chooseTimeModel.getService());
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
        return;
    }


}