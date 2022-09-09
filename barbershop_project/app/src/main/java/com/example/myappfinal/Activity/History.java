package com.example.myappfinal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myappfinal.Adapter.AppointmentListAdapter;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Model.HistoryModel;
import com.example.myappfinal.R;
import com.example.myappfinal.Logic.User;

import java.io.Serializable;


public class History extends AppCompatActivity implements View.OnClickListener, Serializable {

    private Button back;
    private ListView listView;
    private final HistoryModel historyModel=new HistoryModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        back=(Button) findViewById(R.id.back);
        listView=(ListView)findViewById(R.id.listView);
        historyModel.setUser((User)getIntent().getSerializableExtra("user"));

        if (historyModel.getUser() instanceof Customer)historyModel.setAppointments(Customer.getCustomer(historyModel.getUser().getUsername()).getHistory());
        else historyModel.setAppointments(Employee.getHistory());
        AppointmentListAdapter adapter = new AppointmentListAdapter(this,R.layout.adapter_view_layout,historyModel.getAppointments());
        listView.setAdapter(adapter);

        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
        }
    }
}