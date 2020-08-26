package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayRadar extends AppCompatActivity {

    Databasehelper mydb;
    ArrayList<Radar_Inputs> userList;
    ListView listView;
    Radar_Inputs radar_inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_radar_layout);

        mydb = new Databasehelper(getApplicationContext());

        userList = new ArrayList<>();
        Cursor data = mydb.getAllData();
        int numRows = data.getCount();
        if(numRows == 0)
        {
            Toast.makeText(this, "Nothing In DataBase", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()) {
                radar_inputs = new Radar_Inputs(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9), data.getString(10), data.getString(11), data.getString(12));
                userList.add(radar_inputs);
            }
            RadarLayoutAdapter radarLayoutAdapter = new RadarLayoutAdapter(this, R.layout.radar_row, userList);
            listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(radarLayoutAdapter);
        }
//        if (cursor.moveToFirst()) {
//
//            do {
//                String e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
//                e1=cursor.getString(0);
//                e2=cursor.getString(1);
//                e3=cursor.getString(2);
//                e4=cursor.getString(3);
//                e5=cursor.getString(4);
//                e6=cursor.getString(5);
//                e7=cursor.getString(6);
//                e8=cursor.getString(7);
//                e9=cursor.getString(8);
//                e10=cursor.getString(9);
//                e11=cursor.getString(10);
//                Radar_Inputs radar_inputs = new Radar_Inputs(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11);
//                radarLayoutAdapter.add(radar_inputs);
//
//            }
//            while (cursor.moveToNext());
//
//            }


//        ArrayList<String> thelist = new ArrayList<>();
//        Cursor data = mydb.getAllData();
//
//        if(data.getCount() == 0) {
//            Toast.makeText(DisplayRadar.this, "The Database was Empty :(.", Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            while(data.moveToNext()){
//                thelist.add(data.getString(0));
//                thelist.add(data.getString(1));
//                thelist.add(data.getString(2));
//                thelist.add(data.getString(3));
//                thelist.add(data.getString(4));
//                thelist.add(data.getString(5));
//                thelist.add(data.getString(6));
//                thelist.add(data.getString(7));
//                thelist.add(data.getString(8));
//                thelist.add(data.getString(9));
//                thelist.add(data.getString(10));
//                thelist.add(data.getString(11));
//
//                ListAdapter listAdapter = new ArrayAdapter<>(this,R.layout.radar_row, thelist);
//                //setListAdapter(new ArrayAdapter<String>(this, R.layout.radar_row, thelist))
//                listView.setAdapter(listAdapter);
//            }
//        }
    }
}
