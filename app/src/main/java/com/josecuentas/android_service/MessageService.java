package com.josecuentas.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jcuentas on 6/01/17.
 * http://stacktips.com/tutorials/android/android-service-example
 */

public class MessageService extends Service {

    public static final String TAG = MessageService.class.getSimpleName();

    private boolean isRunning = false;
    private Thread mThread;

    @Override public void onCreate() {
        Log.i(TAG, "onCreate");

        isRunning = true;
    }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent instanceof MainView) {
            Log.i(TAG, "onStartCommand: inject MainView");
        } else {
            Log.i(TAG, "onStartCommand: no inject MainView");
        }

        Log.i(TAG, "onStartCommand");


        mThread = new Thread(new Runnable() {
            @Override public void run() {
                Log.i(TAG, "run");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (isRunning) {
                        Log.i(TAG, "Service running");
                    }
                }

                //Stop service once it finishes its task
                stopSelf();
            }
        });
        mThread.start();

        return Service.START_STICKY;
    }

    @Nullable @Override public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override public void onDestroy() {
        isRunning = false;

        Log.i(TAG, "onDestroy");
    }
}
