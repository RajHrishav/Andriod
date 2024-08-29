package com.example.iccsolution.myapplication8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class AlertUtil
{


    public static void showYesNoAlert(String message, Activity activity, OnClickListener onClickListener)
    {
        try
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            dialogBuilder.setMessage(message);
            dialogBuilder.setCancelable(true);
            dialogBuilder.setPositiveButton("Yes", onClickListener);
            dialogBuilder.setNegativeButton("No", onClickListener);
            dialogBuilder.create().show();
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }
    }

    public static void showAlert(String message, Activity activity, OnClickListener onClickListener)
    {
        try
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            dialogBuilder.setMessage(message);
            dialogBuilder.setCancelable(true);
            dialogBuilder.setPositiveButton("Yes", onClickListener);
            dialogBuilder.setNegativeButton("No", onClickListener);
            dialogBuilder.create().show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void showFinishAlert(String message, final Activity activity)
    {
        try
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
            dialogBuilder.setMessage(message);
            dialogBuilder.setCancelable(true);
            dialogBuilder.setPositiveButton("OK", new OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (activity!=null){
                       // activity.finish();
                    }
                    dialog.dismiss();

                }
            });
            dialogBuilder.setOnCancelListener(new OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    if (activity!=null){
                        //activity.finish();
                    }
                    dialog.dismiss();
                }
            });
            dialogBuilder.create().show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
