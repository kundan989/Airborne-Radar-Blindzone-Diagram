package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Databasehelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "parameters.db";
    public static final String TABLE_NAME = "parameters_table";
    public static final String COL_0 = "Id";
    public static final String COL_01 = "Radar_Name";
    public static final String COL_1 = "No_of_Range_Gate";
    public static final String COL_2 = "No_of_Doppler_Filter";
    public static final String COL_3 = "Frequency";
    public static final String COL_4 = "No_of_Clear_PRF";
    public static final String COL_5 = "Antenna_BeamWidthAzimuth";
    public static final String COL_6 = "Antenna_BeamWidthElevation";
    public static final String COL_7 = "Minimum_Range";
    public static final String COL_8 = "Maximum_Range";
    public static final String COL_9 = "Target_Minimum_Velocity";
    public static final String COL_10 = "Target_Maximum_Velocity";
    public static final String COL_11 = "Pulse_Width";

    public Databasehelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (Id INTEGER PRIMARY KEY AUTOINCREMENT,Radar_Name STRING ,No_of_Range_Gate INTEGER, No_of_Doppler_Filter INTEGER, Frequency INTEGER, No_of_Clear_PRF INTEGER, Antenna_BeamWidthAzimuth INTEGER, Antenna_BeamWidthElevation INTEGER, Minimum_Range INTEGER, Maximum_Range INTEGER, Target_Minimum_Velocity INTEGER, Target_Maximum_Velocity INTEGER, Pulse_Width INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If Exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String radar_name, String No_of_Range_Gate, String No_of_Doppler_Filter, String Frequency, String No_of_Clear_PRF, String Antenna_BeamWidthAzimuth, String Antenna_BeamWidthElevation, String Minimum_Range, String Maximum_Range, String Target_Minimum_Velocity, String Target_Maximum_Velocity, String Pulse_Width) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_01, radar_name);
        contentValues.put(COL_1, No_of_Range_Gate);
        contentValues.put(COL_2, No_of_Doppler_Filter);
        contentValues.put(COL_3, Frequency);
        contentValues.put(COL_4, No_of_Clear_PRF);
        contentValues.put(COL_5, Antenna_BeamWidthAzimuth);
        contentValues.put(COL_6, Antenna_BeamWidthElevation);
        contentValues.put(COL_7, Minimum_Range);
        contentValues.put(COL_8, Maximum_Range);
        contentValues.put(COL_9, Target_Minimum_Velocity);
        contentValues.put(COL_10, Target_Maximum_Velocity);
        contentValues.put(COL_11, Pulse_Width);
        Log.d(TAG, "Add Data : Adding " + Frequency + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public List<Radar_Inputs> getnameData() {
        List<Radar_Inputs> radarlist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(cursor.moveToFirst())
        {
            do {
                String e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;
                e1=cursor.getString(0);
                e2=cursor.getString(1);
                e3=cursor.getString(2);
                e4=cursor.getString(3);
                e5=cursor.getString(4);
                e6=cursor.getString(5);
                e7=cursor.getString(6);
                e8=cursor.getString(7);
                e9=cursor.getString(8);
                e10=cursor.getString(9);
                e11=cursor.getString(10);
                e12=cursor.getString(11);
                e13=cursor.getString(12);
                Radar_Inputs radar_inputs = new Radar_Inputs(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13);
                radarlist.add(radar_inputs);

            }
            while (cursor.moveToNext());
        }
        return radarlist;
    }

    public int deleteradar(Radar_Inputs radar_inputs) {
        SQLiteDatabase db = getWritableDatabase();

        return db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(radar_inputs.getId())});
    }

    public int updateradar(Radar_Inputs radar_inputs) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_01, radar_inputs.getName());
        contentValues.put(COL_1, radar_inputs.getNo_of_Range_Gate());
        contentValues.put(COL_2, radar_inputs.getNo_of_Doppler_Filter());
        contentValues.put(COL_3, radar_inputs.getFrequency());
        contentValues.put(COL_4, radar_inputs.getNo_of_Clear_PRF());
        contentValues.put(COL_5, radar_inputs.getAntenna_BeamWidthAzimuth());
        contentValues.put(COL_6, radar_inputs.getAntenna_BeamWidthElevation());
        contentValues.put(COL_7, radar_inputs.getMinimum_Range());
        contentValues.put(COL_8, radar_inputs.getMaximum_Range());
        contentValues.put(COL_9, radar_inputs.getTarget_Minimum_Velocity());
        contentValues.put(COL_10, radar_inputs.getTarget_Maximum_Velocity());
        contentValues.put(COL_11, radar_inputs.getPulse_Width());

        return db.update(TABLE_NAME, contentValues, "id=?", new String[]{String.valueOf(radar_inputs.getId())});

    }
}
