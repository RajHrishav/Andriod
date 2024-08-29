 package com.example.revision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

 public class dest extends AppCompatActivity
{
    TextView  fooddata;
    String sfood;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);


        fooddata = (TextView)findViewById(R.id.lbldest);
        Intent intentdest = getIntent();
         sfood=intentdest.getStringExtra("fooddata");
        finish();

       /* name.setText(Snm);
        pass.setText(Sps);
        salute.setText(Ssl);
        email.setText(Seml);*/
    }

    public void function1()
    {

       /* final String drnk="FANTA";
      Intent intent = new Intent(dest.this,Final.class);
      intent.putExtra("lbl1",sfood);
      intent.putExtra("lbl2",drnk);
      startActivity(intent);*/
    }

    public void function2()
    {
        /*final String drnk="COLA";
        Intent intent = new Intent(dest.this,Final.class);
        intent.putExtra("lbl1",sfood);
        intent.putExtra("lbl2",drnk);
        startActivity(intent);*/

    }

    public void function3()
    {
       /* final String drnk="DEW";
        Intent intent = new Intent(dest.this,Final.class);
        intent.putExtra("lbl1",sfood);
        intent.putExtra("lbl2",drnk);
        startActivity(intent);*/
    }



}
