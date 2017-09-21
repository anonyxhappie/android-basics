package com.example.android.quakereport;

/**
 * Created by dwarf on 9/20/2017.
 */

public class EarthquakeDataModel {

    String magnitude;
    String place;
    String placeOffset;
    String date;
    String time;

    int magnitudeResourceId;

    public EarthquakeDataModel(int magnitudeResourceId, String magnitude, String placeOffset, String place, String date, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.placeOffset = placeOffset;
        this.date = date;
        this.time = time;
        this.magnitudeResourceId = magnitudeResourceId;
    }

    public int getMagnitudeResourceId() {
        return magnitudeResourceId;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public String getPlaceOffset() {
        return placeOffset;
    }

    public String getTime() {
        return time;
    }
}
