package com.example.iccsolution.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
       // showFoodOrder(getString(R.string.donut_order_message));
        Intent payment=new Intent(getApplicationContext(),PaymentActivity.class);
        startActivity(payment);
        finish();
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }

    /**
     * Displays a Toast message for the food order.
     *
     * @param message Message to display.
     */
    public void showFoodOrder(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}
