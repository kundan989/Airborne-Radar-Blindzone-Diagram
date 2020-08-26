package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDetails extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12,ed13;
    Radar_Inputs radar_inputs;
    Databasehelper dbhelper;
    String e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        getSupportActionBar().setTitle("Edit Radar Parameters");

        dbhelper = new Databasehelper(this);
        ed1 =  findViewById(R.id.t0);
        ed2 =  findViewById(R.id.t6);
        ed3 =  findViewById(R.id.t2);
        ed4 =  findViewById(R.id.t3);
        ed5 =  findViewById(R.id.t4);
        ed6 =  findViewById(R.id.t5);
        ed7 =  findViewById(R.id.t7);
        ed8 =  findViewById(R.id.t8);
        ed9 =  findViewById(R.id.t9);
        ed10 =  findViewById(R.id.t10);
        ed11 =  findViewById(R.id.t11);
        ed12 =  findViewById(R.id.t12);
        ed13 =  findViewById(R.id.t13);

        radar_inputs = (Radar_Inputs) getIntent().getExtras().getSerializable("RADAR");

        e1=radar_inputs.getId();

        ed1.setText(radar_inputs.getId());
        ed2.setText(radar_inputs.getName());
        ed3.setText(radar_inputs.getNo_of_Range_Gate());
        ed4.setText(radar_inputs.getNo_of_Doppler_Filter());
        ed5.setText(radar_inputs.getFrequency());
        ed6.setText(radar_inputs.getNo_of_Clear_PRF());
        ed7.setText(radar_inputs.getAntenna_BeamWidthAzimuth());
        ed8.setText(radar_inputs.getAntenna_BeamWidthElevation());
        ed9.setText(radar_inputs.getMinimum_Range());
        ed10.setText(radar_inputs.getMaximum_Range());
        ed11.setText(radar_inputs.getTarget_Minimum_Velocity());
        ed12.setText(radar_inputs.getTarget_Maximum_Velocity());
        ed13.setText(radar_inputs.getPulse_Width());
    }

    public void cancel(View view) {
        finish();
    }

    public void update(View view) {

        String e2 = ed2.getText().toString();
        String e3 = ed3.getText().toString();
        String e4 = ed4.getText().toString();
        String e5 = ed5.getText().toString();
        String e6 = ed6.getText().toString();
        String e7 = ed7.getText().toString();
        String e8 = ed8.getText().toString();
        String e9 = ed9.getText().toString();
        String e10 = ed10.getText().toString();
        String e11 = ed11.getText().toString();
        String e12 = ed12.getText().toString();
        String e13 = ed13.getText().toString();

        Radar_Inputs radar_inputs = new Radar_Inputs(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);

        int result = dbhelper.updateradar(radar_inputs);
        if(result > 0)
        {
            Toast.makeText(this, "Radar Updated", Toast.LENGTH_LONG).show();
            finish();
        }
        else
        {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }

    }
}
