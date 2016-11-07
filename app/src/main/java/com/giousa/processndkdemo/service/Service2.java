package com.giousa.processndkdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Description:
 * Author:Giousa
 * Date:2016/11/7
 * Email:65489469@qq.com
 */
public class Service2 extends Service {

    private final String TAG = Service2.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Service2---->onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG,"Service2---->onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Service2---->onDestroy");
        Intent localIntent = new Intent();
        localIntent.setClass(this, Service2.class); // 销毁时重新启动Service
        this.startService(localIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"Service2---->onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Service2---->onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

}
