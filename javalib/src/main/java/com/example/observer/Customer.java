package com.example.observer;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/04
 * desc   :
 * version: 1.0
 */
public abstract class Customer implements Observer<String>{
    @Override
    public void receiverEvent(String s) {
        dealWithEvent(s);
    }

    protected abstract void dealWithEvent(String s);
}
