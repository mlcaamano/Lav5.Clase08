package com.example.alumno.clase07;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        

        //Handler
        Handler h = new Handler(this);


        //Hilo
        Thread miHilo = new Thread(new MyThread(h));

        miHilo.start();

    }

    @Override
    public boolean handleMessage(Message msg) {
        img = (ImageView) findViewById(R.id.img);

        Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show();


        byte[] bytes = (byte[]) msg.obj;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        img.setImageBitmap(bitmap);

        return true;
    }
}
