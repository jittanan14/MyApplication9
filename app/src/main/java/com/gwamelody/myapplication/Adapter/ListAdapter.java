package com.gwamelody.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwamelody.myapplication.Model.Animals;
import com.gwamelody.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gwa Melody on 9/12/2560.
 */

public class ListAdapter extends ArrayAdapter<Animals> {

    private Context mContext;

    private ArrayList <Animals> mAnimal;
    private int mLayout;


    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Animals> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mAnimal = objects;
        this.mLayout = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(mLayout, null);

        ImageView im = (ImageView) view.findViewById(R.id.imageView);
        TextView te =  (TextView) view.findViewById(R.id.textView);

        Animals a = mAnimal.get(position);

        im.setImageResource(a.getPicture());
        te.setText(a.getThaiName() + "(" + a.getEngName()+")");



        return view;
    }
}
