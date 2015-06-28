package com.jayasuriyat.mysensorapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MyAdapter extends ArrayAdapter {
    Integer[] imag = new Integer[6];

    public MyAdapter(Context context, Integer[] image) {
        super(context, R.layout.layout, image);
        imag = image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater r = LayoutInflater.from(getContext());
        View v = r.inflate(R.layout.layout, parent, false);
        ImageView img = (ImageView) v.findViewById(R.id.image);
        img.setImageResource(imag[position]);
        return v;
    }
}
