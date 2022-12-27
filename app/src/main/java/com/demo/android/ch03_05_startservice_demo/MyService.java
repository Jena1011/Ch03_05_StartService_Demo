package com.demo.android.ch03_05_startservice_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    int counter;
    Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("jena","onCreate");
        if(timer==null){
            timer = new Timer();
            timer.schedule(new MyTask(), 0, 1000);
        }
    }

    class MyTask extends TimerTask{

        @Override
        public void run() {
            counter ++;
            Log.v("jena",counter+"");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("jena","onStartCommand");
        counter = intent.getIntExtra("counter",-1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("jena","onDestroy");
        if(timer!=null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}