package com.example.observer;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/04
 * desc   :
 * version: 1.0
 */
public interface Observer<T> {
    void receiverEvent(T t);
}
