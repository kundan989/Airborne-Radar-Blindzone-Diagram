package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Graph extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int STORAGE_PERMISSION_CODE = 1;
    Radar_Inputs radar_inputs;
    Databasehelper databasehelper;
    File imagePath;

    private Activity mActivity;
    PointsGraphSeries<DataPoint> xyvalues;
    Button save;
    GraphView mscatterplot;

    String azimuth,elevation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        databasehelper = new Databasehelper(this);
        //radar_inputs = (Radar_Inputs) getIntent().getExtras().getSerializable("RADAR");

//        Intent i = getIntent();
//        elevation = i.getStringExtra("Elevation");
//        azimuth = i.getStringExtra("Azimuth");
//        int el = Integer.valueOf(elevation);
//        int az = Integer.valueOf(azimuth);


        save = (Button)findViewById(R.id.savepdf);
//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bitmap bitmap = takeScreenshot();
//                saveBitmap(bitmap);
//                shareIt();
//            }
//        });
        mscatterplot = (GraphView)findViewById(R.id.scatterplot);
        xyvalues = new PointsGraphSeries<>();
        createscatterplot();
//        onBtnClick();
    }

    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    private void shareIt() {
        Uri uri = Uri.fromFile(imagePath);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        String shareBody = "In Tweecher, My highest score with screen shot";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Tweecher score");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void createscatterplot()
    {
        ArrayList<XYValues> xypoints=new ArrayList<>();


        double start = 0;
        double end = 150;
        for(int i = 0; i<40; i++){
            double randomX = new Random().nextDouble();
            double randomY = new Random().nextDouble();
            double x = start + (randomX * (end - start));
            double y = start + (randomY * (end - start));
            xypoints.add(new XYValues(x,y));
        }

        //sort it in ASC order
        xypoints = sortArray(xypoints);

        //add the data to the series
        for(int i = 0;i <xypoints.size(); i++){
            double x = xypoints.get(i).getX();
            double y = xypoints.get(i).getY();
            xyvalues.appendData(new DataPoint(x,y),true, 1000);
        }

        //set some properties
        xyvalues.setShape(PointsGraphSeries.Shape.POINT);
        xyvalues.setColor(Color.RED);
        xyvalues.setSize(5f);
        xyvalues.setTitle("Blindzone Diagram");
        mscatterplot.setBackgroundColor(Color.argb(50, 50, 0, 200));

        //set Scrollable and Scaleable
        mscatterplot.getViewport().setScalable(true);
        mscatterplot.getViewport().setScalableY(true);
        mscatterplot.getViewport().setScrollable(true);
        mscatterplot.getViewport().setScrollableY(true);

        //set manual x bounds
        mscatterplot.getViewport().setYAxisBoundsManual(true);
        mscatterplot.getViewport().setMaxY(150);
        mscatterplot.getViewport().setMinY(0);

        //set manual y bounds
        mscatterplot.getViewport().setXAxisBoundsManual(true);
        mscatterplot.getViewport().setMaxX(150);
        mscatterplot.getViewport().setMinX(0);
        mscatterplot.addSeries(xyvalues);

        GridLabelRenderer gridLabel = mscatterplot.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("Velocity----->");

        GridLabelRenderer gridLabel1 = mscatterplot.getGridLabelRenderer();
        gridLabel1.setVerticalAxisTitle("Range---->");

        mscatterplot.setTitle("BlindZone Diagram");
    }

    /**
     * Sorts an ArrayList<XYValue> with respect to the x values.
     * @param array
     * @return
     */
    private ArrayList<XYValues> sortArray(ArrayList<XYValues> array){
        /*
        //Sorts the xyValues in Ascending order to prepare them for the PointsGraphSeries<DataSet>
         */
        int factor = Integer.parseInt(String.valueOf(Math.round(Math.pow(array.size(),2))));
        int m = array.size()-1;
        int count = 0;
        Log.d(TAG, "sortArray: Sorting the XYArray.");

        while(true){
            m--;
            if(m <= 0){
                m = array.size() - 1;
            }
            Log.d(TAG, "sortArray: m = " + m);
            try{
                //print out the y entrys so we know what the order looks like
                //Log.d(TAG, "sortArray: Order:");
                //for(int n = 0;n < array.size();n++){
                //Log.d(TAG, "sortArray: " + array.get(n).getY());
                //}
                double tempY = array.get(m-1).getY();
                double tempX = array.get(m-1).getX();
                if(tempX > array.get(m).getX() ){
                    array.get(m-1).setY(array.get(m).getY());
                    array.get(m).setY(tempY);
                    array.get(m-1).setX(array.get(m).getX());
                    array.get(m).setX(tempX);
                }
                else if(tempY == array.get(m).getY()){
                    count++;
                    Log.d(TAG, "sortArray: count = " + count);
                }

                else if(array.get(m).getX() > array.get(m-1).getX()){
                    count++;
                    Log.d(TAG, "sortArray: count = " + count);
                }
                //break when factorial is done
                if(count == factor ){
                    break;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                Log.e(TAG, "sortArray: ArrayIndexOutOfBoundsException. Need more than 1 data point to create Plot." +
                        e.getMessage());
                break;
            }
        }
        return array;
    }

    public void onBtnClick(View view) {mscatterplot.takeSnapshotAndShare(Graph.this, "exampleGraph", "GraphViewSnapshot");

// get the bitmap
        Bitmap bitmap = mscatterplot.takeSnapshot();
    }


//    private boolean check(double range, double velocity)
//    {
//        boolean visible=false;
//        int count=0;
//        for(int i=0; i<airborneradar.PRF.size(); i++)
//        {
//            double prf = airborneradar.PRF.element[i];
//
//        }
//    }
}
