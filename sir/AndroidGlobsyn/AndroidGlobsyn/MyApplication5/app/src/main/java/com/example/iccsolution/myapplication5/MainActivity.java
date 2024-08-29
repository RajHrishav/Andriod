package com.example.iccsolution.myapplication5;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // EditText view for the website URI
    private EditText mWebsiteEditText;
    // EditText view for the location URI
    private EditText mLocationEditText;
    // EditText view for the share text
    private EditText mShareTextEditText;
    private  EditText mobileedittext;
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = (EditText) findViewById(R.id.website_edittext);
        mLocationEditText = (EditText) findViewById(R.id.location_editext);
        mShareTextEditText = (EditText) findViewById(R.id.share_edittext);
        mobileedittext= (EditText) findViewById(R.id.mobile_edittext);
    }

    /**
     * Handles the onClick for the "Open Website" button.  Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
      //  if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        //} else {
           // Log.d("ImplicitIntents", "Can't handle this intent!");
       // }
    }

    /**
     * Handles the onClick for the "Open Location" button.  Gets the location
     * text from the edit text and sends an implicit intent for that location.
     *
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openLocation(View view) {
        // Get the string indicating a location.  Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    /**
     * Handles the onClick for the "Share This Text" button.  The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class.  An app chooser appears with the available options for sharing.
     *
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     *
     * @param view The view (Button) that was clicked.
     */
    public void shareText(View view) {
        // Get the shared text.
        String txt = mShareTextEditText.getText().toString();

        // Build the share intent with the mimetype text/plain and launch
        // a chooser for the user to pick an app.
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
    public void callMobile(View view)
    {
       // Intent intent = new Intent(Intent.ACTION_CALL);

        //intent.setData(Uri.parse("tel:" + mobileedittext.getText()));
        //startActivity(intent);
        String phoneNumber=mobileedittext.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

    }
public void sendMessage(String srcNumber,String message)
{
    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + srcNumber));
    intent.putExtra( "sms_body", message );
    startActivity(intent);
}
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}