package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DynamicVariables extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button plot;
    Radar_Inputs radar_inputs;
    Databasehelper databasehelper;
    ArrayAdapter<String> spin_name;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_variables);

        getSupportActionBar().setTitle("Define Dynamic Parameters");

        databasehelper = new Databasehelper(this);
        radar_inputs = (Radar_Inputs) getIntent().getExtras().getSerializable("RADAR");
        String[] radar_name = new String[]{radar_inputs.getName()};

        plot = (Button) findViewById(R.id.button);
        plot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2();
            }
        });


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin_name = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, radar_name);
        spin.setAdapter(spin_name);
//       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Radars, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        ed1=(EditText)findViewById(R.id.editText1);
        ed1=(EditText)findViewById(R.id.editText1);
    }

    public void openActivity2() {
        Intent i = new Intent(this, Graph.class);
//        i.putExtra("RADAR", radar_inputs);
//        i.putExtra("Elevation", ed1.getText().toString());
//        i.putExtra("Azimuth", ed2.getText().toString());
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
