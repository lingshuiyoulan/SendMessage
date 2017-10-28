package com.lanling.sendmessage.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.lanling.sendmessage.email.SendMsgUtil;

/**
 * @author lanling
 *         on 2017/8/6
 */

public class MyService extends Service {
    public static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate() executed");
    }

    String message = "";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand() executed");
        message = intent.getStringExtra("message");
        new Thread(new Runnable() {
            @Override
            public void run() {
                SendMsgUtil.sendMessage(message, "短信通知");
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
