package com.bei.test;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by lzb on 16/12/9.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("bei");
    }
}
