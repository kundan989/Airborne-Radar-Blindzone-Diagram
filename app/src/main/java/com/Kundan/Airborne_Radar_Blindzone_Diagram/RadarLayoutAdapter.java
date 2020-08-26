package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class RadarLayoutAdapter extends ArrayAdapter<Radar_Inputs>
{
    private LayoutInflater mInflater;
    private ArrayList<Radar_Inputs> users;
    private int mViewResourceId;

    public RadarLayoutAdapter(Context context, int textViewResourceId, ArrayList<Radar_Inputs> users)
    {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

//    static class LayoutHandler
//    {
//        TextView tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11;
//    }
//
//    @Override
//    public void add( Object object) {
//        //super.add(object);
//        list.add(object);
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @NonNull
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }


    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = mInflater.inflate(mViewResourceId,null);

       Radar_Inputs radar_inputs = users.get(position);

       if (radar_inputs != null)
       {
//           LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//           layoutHandler = new LayoutHandler();
//           layoutHandler.tt1=(TextView)row.findViewById(R.id.t2);
//           layoutHandler.tt2=(TextView)row.findViewById(R.id.t3);
//           layoutHandler.tt3=(TextView)row.findViewById(R.id.t4);
//           layoutHandler.tt4=(TextView)row.findViewById(R.id.t5);
//           layoutHandler.tt5=(TextView)row.findViewById(R.id.t6);
//           layoutHandler.tt6=(TextView)row.findViewById(R.id.t7);
//           layoutHandler.tt7=(TextView)row.findViewById(R.id.t8);
//           layoutHandler.tt8=(TextView)row.findViewById(R.id.t9);
//           layoutHandler.tt9=(TextView)row.findViewById(R.id.t10);
//           layoutHandler.tt10=(TextView)row.findViewById(R.id.t11);
//           layoutHandler.tt11=(TextView)row.findViewById(R.id.t12);
//           row.setTag(layoutHandler);
           TextView tt0 = (TextView) convertView.findViewById(R.id.t0);
           TextView tt01 = (TextView) convertView.findViewById(R.id.t6);
           TextView tt1 = (TextView) convertView.findViewById(R.id.t2);
           TextView tt2 = (TextView) convertView.findViewById(R.id.t3);
           TextView tt3 = (TextView) convertView.findViewById(R.id.t4);
           TextView tt4 = (TextView) convertView.findViewById(R.id.t5);
           TextView tt5 = (TextView) convertView.findViewById(R.id.t7);
           TextView tt6 = (TextView) convertView.findViewById(R.id.t8);
           TextView tt7 = (TextView) convertView.findViewById(R.id.t9);
           TextView tt8 = (TextView) convertView.findViewById(R.id.t10);
           TextView tt9 = (TextView) convertView.findViewById(R.id.t11);
           TextView tt10 = (TextView) convertView.findViewById(R.id.t12);
           TextView tt11 = (TextView) convertView.findViewById(R.id.t13);

           if (tt0 != null)
           {
               tt0.setText(radar_inputs.getId());
           }

           if (tt01 != null)
           {
               tt01.setText(radar_inputs.getName());
           }

           if (tt1 != null)
           {
               tt1.setText(radar_inputs.getNo_of_Range_Gate());
           }
           if (tt2 != null)
           {
               tt2.setText(radar_inputs.getNo_of_Doppler_Filter());
           }
           if (tt3 != null)
           {
               tt3.setText(radar_inputs.getFrequency());
           }
           if (tt4 != null)
           {
               tt4.setText(radar_inputs.getNo_of_Clear_PRF());
           }
           if (tt5 != null)
           {
               tt5.setText(radar_inputs.getAntenna_BeamWidthAzimuth());
           }
           if (tt6 != null)
           {
               tt6.setText(radar_inputs.getAntenna_BeamWidthElevation());
           }
           if (tt7 != null)
           {
               tt7.setText(radar_inputs.getMinimum_Range());
           }
           if (tt8 != null)
           {
               tt8.setText(radar_inputs.getMaximum_Range());
           }
           if (tt9 != null)
           {
               tt9.setText(radar_inputs.getTarget_Minimum_Velocity());
           }
           if (tt10 != null)
           {
               tt10.setText(radar_inputs.getTarget_Maximum_Velocity());
           }
           if (tt11 != null)
           {
               tt11.setText(radar_inputs.getPulse_Width());
           }


       }
//       else
//       {
//           layoutHandler=(LayoutHandler)row.getTag();
//       }
//
//       Radar_Inputs radar_inputs = (Radar_Inputs)this.getItem(position);
//       layoutHandler.tt1.setText(radar_inputs.getNo_of_Range_Gate());
//       layoutHandler.tt2.setText(radar_inputs.getNo_of_Doppler_Filter());
//       layoutHandler.tt3.setText(radar_inputs.getFrequency());
//       layoutHandler.tt4.setText(radar_inputs.getNo_of_Clear_PRF());
//       layoutHandler.tt5.setText(radar_inputs.getAntenna_BeamWidthAzimuth());
//       layoutHandler.tt6.setText(radar_inputs.getAntenna_BeamWidthElevation());
//       layoutHandler.tt7.setText(radar_inputs.getMinimum_Range());
//       layoutHandler.tt8.setText(radar_inputs.getMaximum_Range());
//       layoutHandler.tt9.setText(radar_inputs.getTarget_Minimum_Velocity());
//       layoutHandler.tt10.setText(radar_inputs.getTarget_Maximum_Velocity());
//       layoutHandler.tt11.setText(radar_inputs.getPulse_Width());

        return convertView;
    }
}
