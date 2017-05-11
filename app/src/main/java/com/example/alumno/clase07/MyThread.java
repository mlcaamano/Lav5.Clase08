package com.example.alumno.clase07;

import android.os.Handler;
import android.os.Message;

/**
 * Created by alumno on 11/05/2017.
 */

public class MyThread implements Runnable {

    Handler h;

    public MyThread(Handler h){
        this.h=h;
    }


    @Override
    public void run() {

        ConexionInternet miConexion= new ConexionInternet();
        Message miMensaje = new Message();

        try{
            miMensaje.obj= miConexion.getBytesDataByGet("https://supermariorun.com/img/stage/mario01.png");

            h.sendMessage(miMensaje);
        }
        catch (Exception e){

        }

    }
}
