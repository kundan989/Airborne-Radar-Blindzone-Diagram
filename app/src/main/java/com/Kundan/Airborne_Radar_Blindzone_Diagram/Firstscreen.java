package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Firstscreen extends AppCompatActivity {

    FloatingActionButton add;
    ListView lvradars;
    List<Radar_Inputs> list;
    ArrayAdapter<Radar_Inputs> arrayAdapter;
    Databasehelper dbhelper;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);
        add = (FloatingActionButton) findViewById(R.id.addfab);
        lvradars = findViewById(R.id.list_firstscreen);
        dbhelper = new Databasehelper(this);



        lvradars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Radar_Inputs radar_inputs = list.get(position);

                Intent intent = new Intent(Firstscreen.this, DisplyIndividualRadar.class);
                intent.putExtra("RADAR", radar_inputs);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMain();
            }
        });
    }

    public void openMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        list = dbhelper.getnameData();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvradars.setAdapter(arrayAdapter);

    }
}
