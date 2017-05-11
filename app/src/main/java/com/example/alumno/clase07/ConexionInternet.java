package com.example.alumno.clase07;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alumno on 11/05/2017.
 */

public class ConexionInternet {

    public byte[] getBytesDataByGet(String strUrl) throws IOException{

        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        int response = urlConnection.getResponseCode();
        Log.d("http", "Response code:" + response);

        if (response==200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;

            while((length = is.read(buffer))!= -1)
            {
                baos.write(buffer, 0 , length);
            }

            is.close();
            return baos.toByteArray();
        }
        else
            throw new IOException();
    }
}
