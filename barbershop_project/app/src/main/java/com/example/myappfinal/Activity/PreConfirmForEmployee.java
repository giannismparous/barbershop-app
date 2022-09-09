package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappfinal.Model.PreConfirmForEmployeeModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;

import java.io.Serializable;

public class PreConfirmForEmployee extends AppCompatActivity implements  View.OnClickListener, Serializable {

    private Button goToConfirm;
    private Button back;
    private EditText nameET;
    private EditText phoneET;
    private final PreConfirmForEmployeeModel preConfirmForEmployeeModel=new PreConfirmForEmployeeModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_confirm_for_employee);

        preConfirmForEmployeeModel.setTime((Integer) getIntent().getSerializableExtra("time"));
        preConfirmForEmployeeModel.setUser((User) getIntent().getSerializableExtra("user"));
        preConfirmForEmployeeModel.setService((Integer) getIntent().getSerializableExtra("service"));
        preConfirmForEmployeeModel.setDay((Integer) getIntent().getSerializableExtra("day"));

        nameET = (EditText) findViewById(R.id.firstname1);
        phoneET=(EditText)  findViewById(R.id.Phone);

        goToConfirm= (Button) findViewById(R.id.goToConfirm);
        back=(Button) findViewById(R.id.back);


        nameET.setOnClickListener(this);
        phoneET.setOnClickListener(this);

        back.setOnClickListener(this);


        goToConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back:
                Intent intent = new Intent(this, ChooseTime.class);
                intent.putExtra("day",preConfirmForEmployeeModel.getDay());
                intent.putExtra("user",preConfirmForEmployeeModel.getUser());
                intent.putExtra("service",preConfirmForEmployeeModel.getService());
                startActivity(intent);
                finish();
                break;
            case R.id.goToConfirm:

                preConfirmForEmployeeModel.setName(nameET.getText().toString());
                preConfirmForEmployeeModel.setPhone(phoneET.getText().toString());

                if(!preConfirmForEmployeeModel.getName().equals("") && !preConfirmForEmployeeModel.getPhone().equals("")){
                    Intent intent2 = new Intent(this, ConfirmAppointment.class);
                    intent2.putExtra("name", preConfirmForEmployeeModel.getName());
                    intent2.putExtra("phone",preConfirmForEmployeeModel.getPhone());
                    intent2.putExtra("time", preConfirmForEmployeeModel.getTime());
                    intent2.putExtra("day", preConfirmForEmployeeModel.getDay());
                    intent2.putExtra("user", preConfirmForEmployeeModel.getUser());
                    intent2.putExtra("service", preConfirmForEmployeeModel.getService());

                    intent2.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    startActivity(intent2);
                    finish();
                    break;
                }else{
                    Toast.makeText(PreConfirmForEmployee.this,"Text all the fields",Toast.LENGTH_SHORT).show();

                }

        }


    }
}