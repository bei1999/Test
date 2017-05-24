package com.bei.test;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by lzb on 16/12/9.
 */
public class MyApplication extends Application {
    private static  Context INSTACE;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("bei");
        INSTACE = this;
    }

    public static Context getContext() {
        return INSTACE;
    }
}
