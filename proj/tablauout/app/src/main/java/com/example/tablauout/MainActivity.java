package com.example.tablauout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
    Context context;
    ArrayList proglist;
//niche wala array enum ki tarah h.
    public static Integer[] progimages=
            {
                    R.drawable.a,R.drawable.b,
                    R.drawable.a,R.drawable.b,
                    R.drawable.a,R.drawable.b

            }
    ;

    public static String[] progNames={"linkedin in","fb","insta","linkedin in","fb","insta"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lst);

        Myadpater adapter = new Myadpater(this,progNames,progimages);
        lv.setAdapter(adapter);







    }
}
/*1.	package com.example.admin.listviewexample;
        2.
        3.	import android.support.v7.app.AppCompatActivity;
        4.	import android.os.Bundle;
        5.	import android.widget.ArrayAdapter;
        6.	import android.widget.ListView;
        7.
        8.	public class MainActivity extends AppCompatActivity {
9.
        10.	String[] mobileArray = {"Java","C++","C#","CSS",
            11.	"HTML","XML",".Net","VisualBasic", "SQL", "Python", "PHP"};
12.
        13.	@Override
14.	protected void onCreate(Bundle savedInstanceState) {
        15.	super.onCreate(savedInstanceState);
        16.	setContentView(R.layout.activity_main);
        17.	ListView listView = (ListView) findViewById(R.id.mobile_list);

        18.	ArrayAdapter adapter = new ArrayAdapter<String>(this,
        19.	R.layout.activity_listview, mobileArray);
        20.
        21.	
        22.	listView.setAdapter(adapter);
        23.	}
24.	}
*/