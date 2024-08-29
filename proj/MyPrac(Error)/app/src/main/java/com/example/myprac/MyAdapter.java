package com.example.myprac;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myprac.R;

import java.util.Arrays;

public class MyAdapter extends ArrayAdapter<String>
{

    final Activity context;
    final Integer[] imgArray;
    final String[] txtArray;

    MyAdapter(Activity context,Integer[] imgArray,String[] txtArray)
    {
        super(context,R.layout.item, Arrays.asList(txtArray));
        this.context = context;
        this.imgArray =imgArray;
        this.txtArray =txtArray;


    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent)
    {
        LayoutInflater inflt = context.getLayoutInflater() ;
        View v =inflt.inflate(R.layout.item,null,true);


        ImageView varImg = (ImageView) v.findViewById(R.id.img);
        TextView varTXT =(TextView) v.findViewById(R.id.txt);

        varImg.setImageResource(imgArray[position]);
        varTXT.setText(txtArray[position]);

        return v;

       // return super.getView(position, convertView, parent);
    }
}
