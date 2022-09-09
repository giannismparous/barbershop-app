package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.Service;
import com.example.myappfinal.R;

public class Statistics extends AppCompatActivity implements View.OnClickListener{

    private TextView avrg_evaluation,openApp,completedApp,total_Value;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        avrg_evaluation=(TextView) findViewById(R.id.avrg_evaluation_Info);
        openApp=(TextView) findViewById(R.id.OpenAppInfo);
        completedApp=(TextView) findViewById(R.id.completeAppInfo);
        total_Value=(TextView) findViewById(R.id.totalValueInfo);

        back=(Button) findViewById(R.id.back);

        avrg_evaluation.setText(String.valueOf(getAverage()));
        int temp=getOpenApp();
        openApp.setText(String.valueOf(temp));
        completedApp.setText(String.valueOf(getCompletedApp()));
        total_Value.setText(String.valueOf(temp* Service.getPrice()));

        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private double getAverage(){

        double count=0;
        double countStars=0;
        for (Customer customer: Customer.getCustomers()){
            if (customer.hasVoted()){
                count++;
                countStars=countStars+(double)customer.getStars();
            }
        }
        if (count==0)return 0;
        return countStars/count;
    }

    private int getOpenApp(){

        int count = 0;

        for (Appointment app: Appointment.getAppointments()){
            if (app.getState().equals("Active"))count++;
        }

        return count;
    }

    private int getCompletedApp(){
        int count = 0;

        for (Appointment app: Appointment.getAppointments()){
            if (app.getState().equals("Completed"))count++;
        }

        return count;
    }
}