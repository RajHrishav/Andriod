package com.example.revision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    RadioGroup  grp1,grp2,grp3;
    RadioButton rbtn1a,rbtn1b,rbtn2a,rbtn2b,rbtn3a,rbtn3b ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        grp1=(RadioGroup) findViewById(R.id.rg1);
        grp2=(RadioGroup) findViewById(R.id.rg2);
        grp3=(RadioGroup) findViewById(R.id.rg3);

        rbtn1a=(RadioButton)findViewById(R.id.rb1a);
        rbtn1b=(RadioButton)findViewById(R.id.rb1b);
        rbtn2a=(RadioButton)findViewById(R.id.rb2a);
        rbtn2b=(RadioButton)findViewById(R.id.rb2b);
        rbtn3a=(RadioButton)findViewById(R.id.rb3a);
        rbtn3b=(RadioButton)findViewById(R.id.rb3b);



    }

    public void function(View v)
    {

        int i,j,k;
        RadioButton a,b,c;
        i=grp1.getCheckedRadioButtonId();
        j=grp2.getCheckedRadioButtonId();
        k=grp3.getCheckedRadioButtonId();
        a=(RadioButton)findViewById(i);
        b=(RadioButton)findViewById(j);
        c=(RadioButton)findViewById(k);

        String strfood ="FOOD1"+ a.getText().toString()+"FOOD2"+b.getText().toString()+"FOOD3"+c.getText().toString();



       //Toast.makeText(MainActivity.this,a.getText().toString()+b.getText().toString()+c.getText().toString(),Toast.LENGTH_SHORT).show();


      Intent intentdest = new Intent(MainActivity.this,dest.class);
     // Intent intentfinal = new Intent(MainActivity.this,Final.class);

        intentdest.putExtra("fooddata",strfood);

        startActivity(intentdest);

    }
}
