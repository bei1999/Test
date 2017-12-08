package com.example.factory;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/08
 * desc   : 成立双肩包厂
 * version: 1.0
 */
public class BackPackFatory extends BagFactory03{
    @Override
    public Product createProduct() {
        return new BackPack();
    }
}
