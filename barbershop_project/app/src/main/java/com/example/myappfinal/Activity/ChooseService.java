package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myappfinal.Model.ChooseServiceModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;
import com.example.myappfinal.View.ChooseView;

import java.io.Serializable;

public class ChooseService extends AppCompatActivity implements  View.OnClickListener, Serializable, ChooseView {

    private Button haircut,shaving,dye,massage,back;
    private final ChooseServiceModel chooseServiceModel=new ChooseServiceModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_view);

        setID();
        infoFromPreviousActivity();
        setListener();
    }


    @Override
    public void onClick(View v) {

        choose(v);

        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                intentForChooseDay();
        }
    }



    public void choose(View v){
        switch (v.getId()){
            case R.id.haircut:
                chooseServiceModel.setService(1);
                break;
            case R.id.shaving:
                chooseServiceModel.setService(2);
                break;
            case R.id.hair_dye:
                chooseServiceModel.setService(3);
                break;
            case R.id.massage:
                chooseServiceModel.setService(4);
                break;
        }

    }

    private void setID() {
        haircut= (Button)  findViewById(R.id.haircut);
        shaving = (Button)  findViewById(R.id.shaving);
        dye= (Button)  findViewById(R.id.hair_dye);
        massage= (Button)  findViewById(R.id.massage);
        back= (Button)  findViewById(R.id.back);
    }
    private void infoFromPreviousActivity() {
        chooseServiceModel.setUser((User) getIntent().getSerializableExtra("user"));
    }
    private void setListener() {
        haircut.setOnClickListener(this);
        shaving.setOnClickListener(this);
        dye.setOnClickListener(this);
        massage.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    //New Intents method
    private void intentForChooseDay() {
        Intent intent = new Intent(this, ChooseDay.class);
        intent.putExtra("user",chooseServiceModel.getUser());
        intent.putExtra("service",chooseServiceModel.getService());
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
        return;
    }
}