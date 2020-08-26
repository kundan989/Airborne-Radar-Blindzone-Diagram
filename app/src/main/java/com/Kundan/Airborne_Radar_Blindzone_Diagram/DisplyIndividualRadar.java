package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DisplyIndividualRadar extends AppCompatActivity {

    TextView ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12,ed13;
    Radar_Inputs radar_inputs;
    Databasehelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply_individual_radar);

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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.threedots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.edit:
                Intent intent = new Intent(DisplyIndividualRadar.this, UpdateDetails.class);
                intent.putExtra("RADAR", radar_inputs);
                startActivity(intent);
                finish();
                break;
            case R.id.delete:

                AlertDialog.Builder builder = new AlertDialog.Builder(DisplyIndividualRadar.this);
                builder.setMessage("Are You Sure to Delete?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int result = dbhelper.deleteradar(radar_inputs);

                        if(result > 0)
                        {
                            Toast.makeText(DisplyIndividualRadar.this, "Radar Deleted", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(DisplyIndividualRadar.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.show();

                break;
            case R.id.blindzonediagram:
                Intent intent1 = new Intent(DisplyIndividualRadar.this, DynamicVariables.class);
                intent1.putExtra("RADAR", radar_inputs);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        radar_inputs = (Radar_Inputs) getIntent().getExtras().getSerializable("RADAR");
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
}
