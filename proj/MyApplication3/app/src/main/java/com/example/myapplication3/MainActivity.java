package com.example.myapplication3;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fun1(View v1)
    {

        FragmentManager obj1=getSupportFragmentManager();
        FragmentTransaction ft1=obj1.beginTransaction();
        ft1.replace(R.id.lay, new BlankFragment2());
        ft1.commit();
    }

    public void fun2(View v2)
    {

        FragmentManager obj2=getSupportFragmentManager();
        FragmentTransaction ft2=obj2.beginTransaction();
        ft2.replace(R.id.lay,new BlankFragment2());
        ft2.commit();
    }


}


