package com.giousa.processndkdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Description:
 * Author:Giousa
 * Date:2016/11/7
 * Email:65489469@qq.com
 */
public class Service1 extends Service {

    private final String TAG = Service1.class.getSimpleName();
    private int recLen = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Service1---->onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG,"Service1---->onStart");
        handler.postDelayed(runnable, 1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Service1---->onDestroy");
        Intent localIntent = new Intent();
        localIntent.setClass(this, Service1.class); // 销毁时重新启动Service
        this.startService(localIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"Service1---->onBind");
        return null;
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            recLen++;
            handler.postDelayed(this, 1000);
            Log.d(TAG,"Service1---->recLen:"+recLen);
        }
    };
}
