package com.example.libraryisolation;

import android.app.Application;

import com.example.libraryisolation.util.net.HttpHelper;
import com.example.libraryisolation.util.net.VolleyHttpProcess;

/**
 * Created by zjt on 2017/6/20.
 * 全局类
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.initIHttpProcess(new VolleyHttpProcess(this));
    }
}
