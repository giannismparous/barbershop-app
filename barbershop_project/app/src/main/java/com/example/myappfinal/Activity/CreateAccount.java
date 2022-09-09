package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappfinal.Model.CreateAccountModel;
import com.example.myappfinal.R;

public class CreateAccount extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private Button register;
    private TextView exit;
    private final CreateAccountModel createAccountModel=new CreateAccountModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        username= (EditText) findViewById(R.id.firstname1);
        password= (EditText) findViewById(R.id.Password1);
        firstName =(EditText) findViewById(R.id.firstName);
        lastName =(EditText)findViewById(R.id.lastName);
        email=(EditText)findViewById(R.id.Email);
        phone=(EditText)findViewById(R.id.Phone);
        exit = (TextView) findViewById(R.id.backR);
        register= (Button) findViewById(R.id.reg) ;

        createAccountModel.setDB(createAccountModel.getCreateAccountPresenter().createNewDB(this));

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String fn=firstName.getText().toString();
                String ln=lastName.getText().toString();
                String em=email.getText().toString();
                String ph=phone.getText().toString();

                if(user.equals("")|| pass.equals("")||fn.equals("")|| ln.equals("")||em.equals("")||ph.equals("")){
                    Toast.makeText(CreateAccount.this,"Text all the fields",Toast.LENGTH_SHORT).show();
                }else {
                   Boolean checkuser=createAccountModel.getCreateAccountPresenter().checkusername(createAccountModel.getDB(),user);
                   if(checkuser==false) {
                       Boolean insert = createAccountModel.getCreateAccountPresenter().insertData(createAccountModel.getDB(),user, pass,fn,ln,em,ph);
                       if(insert == true) {
                           Toast.makeText(CreateAccount.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(), Login.class);
                           startActivity(intent);
                       }else{
                           Toast.makeText(CreateAccount.this, "Register Failed", Toast.LENGTH_SHORT).show();
                       }
                   }else{
                       Toast.makeText(CreateAccount.this, "Name already exists", Toast.LENGTH_SHORT).show();
                   }

                }
            }
        });

    }
}