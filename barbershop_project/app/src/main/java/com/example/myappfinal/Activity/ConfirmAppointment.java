package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappfinal.Logic.DateAppointment;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Model.ConfirmAppointmentModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.Service;
import com.example.myappfinal.Logic.TimeAppointment;
import com.example.myappfinal.Logic.User;

import java.io.Serializable;

public class ConfirmAppointment extends AppCompatActivity implements Serializable, View.OnClickListener {

    private TextView usernameInfo;
    private TextView serviceInfo;
    private TextView dateInfo;
    private TextView timeInfo;
    private TextView phoneInfo;
    private Button confirm;
    private Button back;
    private Button exit;
    private final ConfirmAppointmentModel confirmAppointmentModel=new ConfirmAppointmentModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_appointment);

        confirmAppointmentModel.setUser((User) getIntent().getSerializableExtra("user"));

        if(confirmAppointmentModel.getUser() instanceof Employee){
            confirmAppointmentModel.setName((String) getIntent().getSerializableExtra("name"));
            confirmAppointmentModel.setPhone((String) getIntent().getSerializableExtra("phone"));
        }


        ConfirmInfo();
        fillButton();
        buttonReact();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.confirm:
                if(confirmAppointmentModel.getUser() instanceof Customer){
                    confirmAppointmentModel.getConfirmAppointmentPresenter().createAnAppointment(confirmAppointmentModel.getUser(),confirmAppointmentModel.getService(),confirmAppointmentModel.getDay(),confirmAppointmentModel.getTime());
                    Intent intent2=new Intent();
                    intent2.putExtra("user",confirmAppointmentModel.getUser());
                    setResult(Activity.RESULT_OK, intent2);
                }else{
                    confirmAppointmentModel.getConfirmAppointmentPresenter().createAnAppointment(confirmAppointmentModel.getUser(),confirmAppointmentModel.getService(),confirmAppointmentModel.getDay(),confirmAppointmentModel.getTime(),confirmAppointmentModel.getName(),confirmAppointmentModel.getPhone());
                    Intent intent2=new Intent();
                    intent2.putExtra("user",confirmAppointmentModel.getUser());
                    setResult(Activity.RESULT_OK, intent2);
                }
                Toast.makeText(ConfirmAppointment.this,"Appointment has completed!!!",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.back:
                Intent intent = new Intent(this,ChooseTime.class);
                intent.putExtra("day",confirmAppointmentModel.getDay());
                intent.putExtra("user",confirmAppointmentModel.getUser());
                intent.putExtra("service",confirmAppointmentModel.getService());
                startActivity(intent);
                finish();
                break;
            case R.id.exit:

                finish();
                break;
        }
    }


    private void fillButton() {
        confirm =(Button) findViewById(R.id.confirm);
        back =(Button) findViewById(R.id.back);
        exit=(Button) findViewById(R.id.exit);
    }

    private void buttonReact() {
        confirm.setOnClickListener(this);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    private void ConfirmInfo() {
        infoForUsername();

        infoForPhone();

        infoForService();

        infoForDate();

        infoForTime();
    }

    private void infoForTime() {
        confirmAppointmentModel.setTime((Integer) getIntent().getSerializableExtra("time"));
        timeInfo = (TextView) findViewById(R.id.timeInfo);

        timeInfo.setText(TimeAppointment.getTimeAppointmentTime(confirmAppointmentModel.getTime()));
    }

    private void infoForDate() {
        confirmAppointmentModel.setDay((Integer) getIntent().getSerializableExtra("day"));
        dateInfo = (TextView) findViewById(R.id.dateInfo);
        dateInfo.setText(DateAppointment.getDateAppointmentDate(confirmAppointmentModel.getDay()));
    }

    private void infoForService() {
        confirmAppointmentModel.setService((Integer) getIntent().getSerializableExtra("service"));
        serviceInfo = (TextView) findViewById(R.id.serviceInfo);
        serviceInfo.setText(Service.getService(confirmAppointmentModel.getService()).getName());
    }

    private void infoForPhone() {
        phoneInfo = (TextView) findViewById(R.id.phoneInfo);
        if (confirmAppointmentModel.getUser() instanceof Customer)
            phoneInfo.setText(confirmAppointmentModel.getUser().getPhoneNumber());
        else {
            phoneInfo.setText(confirmAppointmentModel.getPhone());
        }
    }

    private void infoForUsername() {

        usernameInfo = (TextView) findViewById(R.id.usernameInfo);
        if(confirmAppointmentModel.getUser() instanceof Customer)
            usernameInfo.setText(confirmAppointmentModel.getUser().getUsername());
        else
            usernameInfo.setText(confirmAppointmentModel.getName());
    }
}