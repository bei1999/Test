package com.bei.test;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.bei.test.utils.AppUtils;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.orhanobut.logger.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import okhttp3.OkHttpClient;

/**
 * Created by lzb on 16/12/9.
 */
public class MyApplication extends Application {
    private static Context INSTACE;
    /**
     * 维护Activity的List
     */
    private static List<Activity> mActivitys = Collections.synchronizedList(new LinkedList<Activity>());


    @Override
    public void onCreate() {
        super.onCreate();

        /**检测当前进程名称是否为应用包名，否则return （多进程会存在onCreate() 反复初始化问题，项目中数据库初始化遇到过*/
        if (!AppUtils.getCurProcessName(this).equals(getPackageName())) {
            return;
        }
        init();
    }

    private void init() {
        Logger.init("bei");
        INSTACE = this;

        /**crash异常捕获*/
        if (BuildConfig.DEBUG) {
            CustomActivityOnCrash.install(this);
        }
        /**注册全局activity 监听*/
        registerActivityListener();

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


    }

    public static Context getContext() {
        return INSTACE;
    }


    /**
     * 获取当前Activity（栈中最后一个压入得）
     */
    public static Activity getCurrentActivity() {
        if (mActivitys == null || mActivitys.isEmpty()) {
            return null;
        }
        Activity activity = mActivitys.get(mActivitys.size() - 1);
        return activity;
    }


    /**
     * 注册ActivityListener
     */
    private void registerActivityListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {
                }

                @Override
                public void onActivityResumed(Activity activity) {
                }

                @Override
                public void onActivityPaused(Activity activity) {
                }

                @Override
                public void onActivityStopped(Activity activity) {
                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });
        }
    }


}
