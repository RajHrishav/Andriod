package com.example.iccsolution.sqlliteprac;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void onClickShowAlert(View view) {
        // Build the alert dialog.
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(Main4Activity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle(R.string.alert_title);
        // Set the dialog message.
        myAlertBuilder.setMessage(R.string.alert_message);
        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                Toast.makeText(getApplicationContext(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked the CANCEL button.
                Toast.makeText(getApplicationContext(), R.string.pressed_cancel,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Create and show the AlertDialog.
        myAlertBuilder.show();

    }

}
