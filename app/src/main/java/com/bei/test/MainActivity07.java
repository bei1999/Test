package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.Toast;


import com.bei.test.utils.CustomToast;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/04/18
 * desc   :
 * version: 1.0
 */
public class MainActivity07 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);


        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("lilei");
                subscriber.onNext("hanmeimei");
                subscriber.onCompleted();

            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("observable create :"+s);
            }
        });


        Observable.just("lilei","hanmeimei")
                .subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("observable just:"+s);
            }
        });

//        Observable.interval(10, TimeUnit.SECONDS)
//                .observeOn(Schedulers.io())
//                .flatMap(aLong -> service.polling(userId));
              Observable.interval(5, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("bei","onNext()---------");
                        Looper.prepare();
                        CustomToast.showToast(MainActivity07.this,"network error",Toast.LENGTH_SHORT);
                        Looper.loop();
                    }
                });

    }
}
