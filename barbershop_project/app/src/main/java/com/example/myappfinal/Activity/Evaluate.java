package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.User;
import com.example.myappfinal.Model.EvaluateModel;
import com.example.myappfinal.R;

import java.io.Serializable;

public class Evaluate extends AppCompatActivity implements Serializable, View.OnClickListener {

    RatingBar ratingBarHaircut;
    Button confirmEvaluation,back;
    private final EvaluateModel evaluateModel=new EvaluateModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        ratingBarHaircut=findViewById(R.id.ratingBar);


        evaluateModel.setUser((User) getIntent().getSerializableExtra("user"));

        confirmEvaluation=(Button)findViewById(R.id.confirm_evaluation);
        back=(Button) findViewById(R.id.back);

        confirmEvaluation.setOnClickListener(this);
        back.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_evaluation:
                if(you_can_evaluate() && !Customer.getCustomer(evaluateModel.getUser().getUsername()).hasVoted()) {
                    evaluateModel.setR1(ratingBarHaircut.getRating());
                    Customer.getCustomer(evaluateModel.getUser().getUsername()).vote((int)evaluateModel.getR1());
                    Toast.makeText(this, "Successful Evaluation", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "You don't have completed an Appointment to Evaluate it or you hav already evaluated", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back:
                finish();
        }
    }


    public boolean you_can_evaluate(){
        for(Appointment a : Customer.getCustomer(evaluateModel.getUser().getUsername()).getHistory()){
            if(a.getState().equals("Active")){
                return true;
            }
        }

        return false;
    }


}