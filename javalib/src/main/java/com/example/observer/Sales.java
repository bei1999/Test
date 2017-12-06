package com.example.observer;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/04
 * desc   :
 * version: 1.0
 */

public class Sales<T> {
    Observer<T> o;

    /**
     * 发布信息
     */
    public void notifyCustomer(T t){
        if (o == null)
            throw new NullPointerException("you must regist Observer first!");
        notifyData(t);
    }

    /**
     * 通知订阅者
     */
    public void notifyData(T t){
        o.receiverEvent(t);
    }

    /**
     * 注册一个观察者
     */
    public void registObserver(Observer<T> o){
        this.o = o;
    }

    /**
     * 在你需要的时候调用这个方法，防止内存泄露
     */
    public void unregistObserver(){
        this.o = null;
    }
}
