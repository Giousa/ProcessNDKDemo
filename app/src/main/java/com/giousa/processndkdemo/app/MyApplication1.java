package com.giousa.processndkdemo.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.giousa.processndkdemo.receiver.Receiver1;
import com.giousa.processndkdemo.receiver.Receiver2;
import com.giousa.processndkdemo.service.Service1;
import com.giousa.processndkdemo.service.Service2;
import com.marswin89.marsdaemon.DaemonApplication;
import com.marswin89.marsdaemon.DaemonConfigurations;

/**
 * Description:
 * Author:Giousa
 * Date:2016/11/7
 * Email:65489469@qq.com
 */
public class MyApplication1 extends DaemonApplication {

    private final String TAG = MyApplication1.class.getSimpleName();

    @Override
    protected DaemonConfigurations getDaemonConfigurations() {
        DaemonConfigurations.DaemonConfiguration configuration1 = new DaemonConfigurations.DaemonConfiguration("com.giousa.processndkdemo.service:process1", Service1.class.getCanonicalName(), Receiver1.class.getCanonicalName());
        DaemonConfigurations.DaemonConfiguration configuration2 = new DaemonConfigurations.DaemonConfiguration("com.giousa.processndkdemo.service:process2", Service2.class.getCanonicalName(), Receiver2.class.getCanonicalName());
        DaemonConfigurations.DaemonListener listener = new MyDaemonListener();
        //return new DaemonConfigurations(configuration1, configuration2);//listener can be null
        return new DaemonConfigurations(configuration1, configuration2, listener);
    }

    private class MyDaemonListener implements DaemonConfigurations.DaemonListener {
        @Override
        public void onPersistentStart(Context context) {
            Log.d(TAG,"onPersistentStart");
        }

        @Override
        public void onDaemonAssistantStart(Context context) {
            Log.d(TAG,"onDaemonAssistantStart");
        }

        @Override
        public void onWatchDaemonDaed() {
            Log.d(TAG,"onWatchDaemonDaed");
        }
    }
}
