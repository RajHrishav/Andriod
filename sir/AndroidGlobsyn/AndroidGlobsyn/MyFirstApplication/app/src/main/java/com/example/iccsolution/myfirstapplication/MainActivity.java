package com.example.iccsolution.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn = null;
TextView tv1=null;
CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.link_to_register);
        chk=(CheckBox) findViewById(R.id.chk1);
        btn = (Button) findViewById(R.id.btnLogin);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Button Clicked"+tv1.getText(), Toast.LENGTH_SHORT).show();
    }
});

tv1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "tv Clicked"+tv1.getText(), Toast.LENGTH_SHORT).show();
    }
});

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "tv Clicked"+tv1.getText(), Toast.LENGTH_SHORT).show();
                }
            else {
                    // Remove the meat

                }
                break;
            case R.id.checkbox_cheese:
                if (checked) {
                    // Cheese me
                }
            else {
                    // I'm lactose intolerant
                }
                break;
            // TODO: Veggie sandwich
        }
    }
}
