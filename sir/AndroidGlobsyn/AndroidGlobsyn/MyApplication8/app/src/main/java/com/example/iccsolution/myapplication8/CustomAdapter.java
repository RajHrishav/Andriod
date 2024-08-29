package com.example.iccsolution.myapplication8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
List<Friend> lstfriend=null;
final Context context;

    public CustomAdapter(Context context,List<Friend> friends) {
        this.context = context;
        this.lstfriend=friends;
    }

    @Override
    public int getCount() {
        if(lstfriend==null || lstfriend.size()==0) {
            return -1;
        }
        return lstfriend.size();
    }

    @Override
    public Object getItem(int position) {
        if(lstfriend==null || lstfriend.size()==0) {
            return null;
        }
        return lstfriend.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            LayoutInflater li=LayoutInflater.from(context);
          v=  li.inflate(R.layout.friend_layout,parent,false);
            TextView tv=v.findViewById(R.id.name);
            tv.setText(lstfriend.get(position).getName());
        }
        return v;
    }
}
