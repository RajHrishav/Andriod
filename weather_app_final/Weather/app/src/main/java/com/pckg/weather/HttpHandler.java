package com.pckg.weather;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {

            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");//do tarika h[GET]and[POST] post secure h jyada.
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
            /* java me file se read & write krne ke liye iska use krte h but wha []getInputSteam] ki jagah [System.in] use krte h
            //yha jo data aya  h service provider se usko String me convert kr rhe h.Is method ko hmlog define krenge
        }*/
        }
        catch (Exception e)
        {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line).append('\n');
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
