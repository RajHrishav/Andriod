package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btn,btn1;


    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn  = (Button)findViewById(R.id.button);

        btn1 = (Button) findViewById(R.id.button1);
      /* et1 = (EditText)findViewById(R.id.txt1);
        et2 = (EditText)findViewById(R.id.txt2);*/
        }


        public void hello(View v)
        {
            final Context context = v.getRootView().getContext();

             LayoutInflater inflt = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final View formElementsView = inflt.inflate(R.layout.layout,null,false);
            //run time par fragment ko lane ke liye framlayout & fragment ke concept ka use krte h.
            // fragment ka xml le sath sath java file v hota h.
            //isme main activity ka kuch part frame layout se le lete h. & Is jagah me frgament ayega.

            //runtime pr koi view lane ke liye Layout inflatter ka use krte h.
            //view ka keval xml file hota h.
            //isme main activity ko koi v part viewke liye reserve nhi rhata h.main activity pura bhara rhe to ye kam krta h
            //ye alag se ata h.

            final  EditText et1,et2;
            et1 = (EditText)formElementsView.findViewById(R.id.txt1);
            et2 = (EditText)formElementsView.findViewById(R.id.txt2);

            AlertDialog.Builder obj  = new AlertDialog.Builder(MainActivity.this);
            obj.setTitle("it is title");
            obj.setView(formElementsView);

           obj.setPositiveButton("OK",
                   new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Toast.makeText(getApplicationContext(),"it is positve button",Toast.LENGTH_SHORT).show();

                        }
                    }
                );



  /*  public void func1(View v)
    {
        Toast.makeText(getApplicationContext(),"22222",Toast.LENGTH_SHORT).show();

    }



    public void func2(View v)
    {

        Toast.makeText(getApplicationContext(),"22222",Toast.LENGTH_SHORT).show();

    }*/
   /* public void btnfun(View view)
    {
        AlertDialog.Builder obj  = new AlertDialog.Builder(MainActivity.this);
        obj.setTitle("it is title");
        obj.setMessage("welcome");
        //
        obj.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"it is positve button",Toast.LENGTH_SHORT).show();

            }
        });
        obj.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"it is negative button",Toast.LENGTH_SHORT).show();

            }
        });

        obj.show();//ye line dialog show krne ke liye h,iske bina alert dialog show hi nni hoga.
        */
    }

