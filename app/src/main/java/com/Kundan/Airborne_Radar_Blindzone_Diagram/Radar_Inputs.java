package com.Kundan.Airborne_Radar_Blindzone_Diagram;

import java.io.Serializable;

public class Radar_Inputs implements Serializable
{
    private String Id;
    private String Name;
    private String No_of_Range_Gate;
    private String No_of_Doppler_Filter;
    private String Frequency;
    private String No_of_Clear_PRF;
    private String Antenna_BeamWidthAzimuth;
    private String Antenna_BeamWidthElevation;
    private String Minimum_Range;
    private String Maximum_Range;
    private String Target_Minimum_Velocity;
    private String Target_Maximum_Velocity;
    private String Pulse_Width;

    public Radar_Inputs(String Name, String no_of_Range_Gate, String no_of_Doppler_Filter, String frequency, String no_of_Clear_PRF, String antenna_BeamWidthAzimuth, String antenna_BeamWidthElevation, String minimum_Range, String maximum_Range, String target_Minimum_Velocity, String target_Maximum_Velocity, String pulse_Width) {
        Name = Name;
        No_of_Range_Gate = no_of_Range_Gate;
        No_of_Doppler_Filter = no_of_Doppler_Filter;
        Frequency = frequency;
        No_of_Clear_PRF = no_of_Clear_PRF;
        Antenna_BeamWidthAzimuth = antenna_BeamWidthAzimuth;
        Antenna_BeamWidthElevation = antenna_BeamWidthElevation;
        Minimum_Range = minimum_Range;
        Maximum_Range = maximum_Range;
        Target_Minimum_Velocity = target_Minimum_Velocity;
        Target_Maximum_Velocity = target_Maximum_Velocity;
        Pulse_Width = pulse_Width;
    }

    public Radar_Inputs(String id, String name, String no_of_Range_Gate, String no_of_Doppler_Filter, String frequency, String no_of_Clear_PRF, String antenna_BeamWidthAzimuth, String antenna_BeamWidthElevation, String minimum_Range, String maximum_Range, String target_Minimum_Velocity, String target_Maximum_Velocity, String pulse_Width) {
        Id = id;
        Name = name;
        No_of_Range_Gate = no_of_Range_Gate;
        No_of_Doppler_Filter = no_of_Doppler_Filter;
        Frequency = frequency;
        No_of_Clear_PRF = no_of_Clear_PRF;
        Antenna_BeamWidthAzimuth = antenna_BeamWidthAzimuth;
        Antenna_BeamWidthElevation = antenna_BeamWidthElevation;
        Minimum_Range = minimum_Range;
        Maximum_Range = maximum_Range;
        Target_Minimum_Velocity = target_Minimum_Velocity;
        Target_Maximum_Velocity = target_Maximum_Velocity;
        Pulse_Width = pulse_Width;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNo_of_Range_Gate() {
        return No_of_Range_Gate;
    }

    public void setNo_of_Range_Gate(String no_of_Range_Gate) {
        No_of_Range_Gate = no_of_Range_Gate;
    }

    public String getNo_of_Doppler_Filter() {
        return No_of_Doppler_Filter;
    }

    public void setNo_of_Doppler_Filter(String no_of_Doppler_Filter) {
        No_of_Doppler_Filter = no_of_Doppler_Filter;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    public String getNo_of_Clear_PRF() {
        return No_of_Clear_PRF;
    }

    public void setNo_of_Clear_PRF(String no_of_Clear_PRF) {
        No_of_Clear_PRF = no_of_Clear_PRF;
    }

    public String getAntenna_BeamWidthAzimuth() {
        return Antenna_BeamWidthAzimuth;
    }

    public void setAntenna_BeamWidthAzimuth(String antenna_BeamWidthAzimuth) {
        Antenna_BeamWidthAzimuth = antenna_BeamWidthAzimuth;
    }

    public String getAntenna_BeamWidthElevation() {
        return Antenna_BeamWidthElevation;
    }

    public void setAntenna_BeamWidthElevation(String antenna_BeamWidthElevation) {
        Antenna_BeamWidthElevation = antenna_BeamWidthElevation;
    }

    public String getMinimum_Range() {
        return Minimum_Range;
    }

    public void setMinimum_Range(String minimum_Range) {
        Minimum_Range = minimum_Range;
    }

    public String getMaximum_Range() {
        return Maximum_Range;
    }

    public void setMaximum_Range(String maximum_Range) {
        Maximum_Range = maximum_Range;
    }

    public String getTarget_Minimum_Velocity() {
        return Target_Minimum_Velocity;
    }

    public void setTarget_Minimum_Velocity(String target_Minimum_Velocity) {
        Target_Minimum_Velocity = target_Minimum_Velocity;
    }

    public String getTarget_Maximum_Velocity() {
        return Target_Maximum_Velocity;
    }

    public void setTarget_Maximum_Velocity(String target_Maximum_Velocity) {
        Target_Maximum_Velocity = target_Maximum_Velocity;
    }

    public String getPulse_Width() {
        return Pulse_Width;
    }

    public void setPulse_Width(String pulse_Width) {
        Pulse_Width = pulse_Width;
    }

    @Override
    public String toString()
    {
        return Name;
    }
}
