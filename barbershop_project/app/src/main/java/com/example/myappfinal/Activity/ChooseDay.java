package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myappfinal.Model.ChooseDayModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;
import com.example.myappfinal.View.ChooseView;

import java.io.Serializable;

public class ChooseDay extends AppCompatActivity implements View.OnClickListener, Serializable, ChooseView {

    private Button monday,tuesday,thursday,wednesday,friday,saturday,back;
    private final ChooseDayModel chooseDayModel=new ChooseDayModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_day);

        setID();
        infoFromPreviousActivity();
        setListener();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                IntentBack();
                break;
            default:
                IntentChooseTime(v);
        }
    }



    public void choose(View v){
        switch (v.getId()){
            case R.id.monday:
                chooseDayModel.setDay(1);
                break;
            case R.id.tuesday:
                chooseDayModel.setDay(2);
                break;
            case R.id.thursday:
                chooseDayModel.setDay(3);
                break;
            case R.id.wed:
                chooseDayModel.setDay(4);
                break;
            case R.id.friday:
                chooseDayModel.setDay(5);
                break;
            case R.id.saturday:
                chooseDayModel.setDay(6);
                break;
        }

    }


    private void setID() {
        monday=(Button) findViewById(R.id.monday);
        tuesday=(Button) findViewById(R.id.tuesday);
        thursday=(Button) findViewById(R.id.thursday);
        wednesday=(Button) findViewById(R.id.wed);
        friday=(Button) findViewById(R.id.friday);
        saturday=(Button) findViewById(R.id.saturday);
        back=(Button) findViewById(R.id.back);
    }
    private void infoFromPreviousActivity() {
        chooseDayModel.setUser((User) getIntent().getSerializableExtra("user"));
        chooseDayModel.setService((Integer) getIntent().getSerializableExtra("service"));
    }
    private void setListener() {
        monday.setOnClickListener(this);
        tuesday.setOnClickListener(this);
        thursday.setOnClickListener(this);
        wednesday.setOnClickListener(this);
        friday.setOnClickListener(this);
        saturday.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    //New Intents method
    private void IntentChooseTime(View v) {
        choose(v);
        Intent intent = new Intent(this, ChooseTime.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        intent.putExtra("day",chooseDayModel.getDay());
        intent.putExtra("user",chooseDayModel.getUser());
        intent.putExtra("service",chooseDayModel.getService());
        startActivity(intent);
        finish();
        return;
    }
    private void IntentBack() {
        Intent intent2=new Intent(this, ChooseService.class);
        intent2.putExtra("user",chooseDayModel.getUser());
        startActivity(intent2);
        finish();
        return;
    }

}