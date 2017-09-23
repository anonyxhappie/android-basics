package com.anonyxhappie.dwarf.pms1;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by dwarf on 9/23/2017.
 */

public class GridAdapter extends ArrayAdapter<MovieModel> {

    public GridAdapter(Context context, ArrayList<MovieModel> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(R.layout.grid_item, parent, false);
        }

        MovieModel movieModel = getItem(position);

        ImageView imageView = (ImageView) v.findViewById(R.id.image);

        Glide.with(getContext())
                .load(Utils.generateImageUrl(movieModel.getPoster_path()))
                .into(imageView);

        return v;
    }
}
