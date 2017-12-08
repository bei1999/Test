package com.example.factory;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/08
 * desc   : 江南皮革厂
 * version: 1.0
 */
public class BagFactory {
    public Product productBag(String type){
        if ("backpack".equals(type)) {
            return new BackPack();
        } else if ("handbag".equals(type)) {
            return new HandBag();
        } else if ("wallet".equals(type)) {
            return new Wallet();
        }else {
            System.out.println("没有这种类型...");
            return null;
        }
    }
}
