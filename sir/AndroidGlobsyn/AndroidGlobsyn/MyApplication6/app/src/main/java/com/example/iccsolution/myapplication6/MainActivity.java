package com.example.iccsolution.myapplication6;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Show_Frag1(View v)
    {
       FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.myplace_holder,new BlankFragment());
        ft.commit();

    }
}
