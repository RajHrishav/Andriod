package com.example.tablauout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadpater extends ArrayAdapter<String>
{
    private final Activity context;//ab chuki hmlog adapter alag se ek class bna kr use kr rhe h isliye Activity class ka obj chaiye.
    private final String[] progNames;//array of texts
    private final Integer[] progImages;//array of images


    public Myadpater(Activity context, String[] progNames, Integer[] progImages)
    {
        super(context,R.layout.item,progNames);
        this.context = context;
        this.progNames = progNames;
        this.progImages = progImages;
    }

    @Override
  //Array Adpter ek class h jisme getView() method phle se define h,hmlog custom ListView ke case me is method ko override kr ke use kr skte h.
  //getView() method ko call krne ki jaroorat nhi hoti ,wo khud pr khud call hote jata hai,jaise jaise screen pr list items show hote hai.

    public View getView(int position, View convertView,  ViewGroup parent)
    {
        LayoutInflater obj =  context.getLayoutInflater();
        View rowView = obj.inflate(R.layout.item,null,true);

        //yha jo naya view bna h us se Textview & image ko link kr rhe h .

        TextView txtTitle = (TextView)rowView.findViewById(R.id.txtItem);
        ImageView imgview = (ImageView)rowView.findViewById(R.id.imgItem);
      

  //niche ke lines me hmlog view ko fill kr rhe h.

        txtTitle.setText(progNames[position]);
        imgview.setImageResource(progImages[position]);

        return rowView;




    }
}
