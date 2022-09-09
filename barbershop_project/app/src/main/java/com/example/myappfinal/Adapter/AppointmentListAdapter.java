package com.example.myappfinal.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.R;

import java.util.ArrayList;


public class AppointmentListAdapter extends ArrayAdapter<Appointment> {

    private String state,date,time;
    private TextView stateT,dateT,timeT;
    private Context mContext;
    int mRecource;


    public AppointmentListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Appointment> objects) {
        super(context, resource, objects);
        mContext=context;
        mRecource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Don't re-inflate unless necessary
        if( convertView == null ) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mRecource,parent,false);
        }

        // Get the state of the current row
        Appointment appt = getItem(position);
        String state = appt.getState();
        String service = appt.getService().getName();
        String date = appt.getDate();
        String time = appt.getStartTime();

        // These should NOT be class members
        TextView stateT = convertView.findViewById(R.id.state);
        TextView serviceT = convertView.findViewById(R.id.service);
        TextView dateT = convertView.findViewById(R.id.date);
        TextView timeT = convertView.findViewById(R.id.time);

        // Set the row's values
        stateT.setText(state);
        serviceT.setText(service);
        dateT.setText(date);
        timeT.setText(time);

        Button button = convertView.findViewById(R.id.button);

        if(state.equals("Canceled")){
            Drawable buttonDrawable = button.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            DrawableCompat.setTint(buttonDrawable, Color.BLACK);
            button.setBackground(buttonDrawable);

        }
        else {
            button.setEnabled(true);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get the current row state - since it may have been
                    // updated since the listener was created
                    String rowState = appt.getState();

                    if(rowState.equals("Active")) {
                        appt.cancel();
                        String newState = appt.getState();

                        // stateT here refers to just this row's TextView now
                        stateT.setText(newState);

                        Drawable buttonDrawable = button.getBackground();
                        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                        DrawableCompat.setTint(buttonDrawable, Color.BLACK);
                        button.setBackground(buttonDrawable);

                        // may also want to disable the button
                        button.setEnabled(false);
                    }
                }
            });
        }

        return convertView;
    }



}
