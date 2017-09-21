package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by dwarf on 9/20/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeDataModel> {

    public EarthquakeAdapter(Context context, ArrayList<EarthquakeDataModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.list_item, parent, false);
        }

        EarthquakeDataModel earthquakeDataModel = getItem(position);

        TextView tv_magnitude = (TextView) v.findViewById(R.id.tv_magnitude);
        TextView tv_place = (TextView) v.findViewById(R.id.tv_place);
        TextView tv_placeOffset = (TextView) v.findViewById(R.id.tv_placeOffset);
        TextView tv_date = (TextView) v.findViewById(R.id.tv_date);
        TextView tv_time = (TextView) v.findViewById(R.id.tv_time);

        tv_magnitude.setText(earthquakeDataModel.getMagnitude());
        tv_magnitude.setBackgroundColor(earthquakeDataModel.getMagnitudeResourceId());
        tv_place.setText(earthquakeDataModel.getPlace());
        tv_placeOffset.setText(earthquakeDataModel.getPlaceOffset());
        tv_date.setText(earthquakeDataModel.getDate());
        tv_time.setText(earthquakeDataModel.getTime());

        return v;
    }
}
