package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dwarf on 9/18/2017.
 */

public class WordAdapter<Word> extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        com.example.android.miwok.Word current  = (com.example.android.miwok.Word) getItem(position);

        TextView textViewEW = (TextView) listItemView.findViewById(R.id.tv_english_word);
        textViewEW.setText(current.geteWord());
        TextView textViewMW = (TextView) listItemView.findViewById(R.id.tv_miwok_word);
        textViewMW.setText(current.getmWord());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.iv_image);

        if (current.hasImage()){
            imageView.setImageResource(current.getmImageId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
