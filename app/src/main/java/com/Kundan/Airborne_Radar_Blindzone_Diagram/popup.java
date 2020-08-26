package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class popup extends AppCompatActivity {

    Button save;
    public static ArrayList<String> addArray = new ArrayList<String>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        txt = findViewById(R.id.edittext1);
        show = findViewById(R.id.listview1);
        save=findViewById(R.id.button1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
                addArray.add(getInput);
                txt.setText("");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(popup.this,android.R.layout.simple_list_item_1, addArray);
                show.setAdapter(adapter);

            }
        });
    }
}
