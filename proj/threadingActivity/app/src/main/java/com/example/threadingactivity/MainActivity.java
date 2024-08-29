package com.example.threadingactivity;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    TextView t;
    public int ProgressValue;
    Button b;
    protected Handler handler;//handler ek event of thread h,jo ki main activty me update send krne ke liye use hota h.it is a class.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.txt1);
        b = (Button) findViewById(R.id.button);
        //Handler ek class h & Handler.Callback ek interface h.
        handler = new Handler(new Handler.Callback(){


            public boolean handleMessage(Message msg)

            {

                if (msg.what == 0) {
                    t.setText("progress=" + ProgressValue + "^%");
                } else if (msg.what == 1) {
                    t.setText("complted" + ProgressValue + "%");
                }
                return true;
            }
        });
    }


    public void btnclick(View view) {
        CountngThread ct = new CountngThread(0);
        Thread obj = new Thread(ct);
        obj.start();
    }

//niche jo  class h wo inner class h main activity class ke andar isliye isme v public lga skte h.
    public class CountngThread implements Runnable {
        int i = 0;

        CountngThread(int start) {
            i = start;
        }

        @Override
        public void run() {
            while (i < 100)//i.e
            {
                SystemClock.sleep(200);//
                i++;
                if (i % 5 == 0) {
                    ProgressValue = i;
                    handler.sendEmptyMessage(0);//handler to send the update
                    //0 mltb process avi complete nhi hua h

                }

                ProgressValue = i;
                handler.sendEmptyMessage(1);//1 mtlb process completeho gya h.
            }

        }
    }
}