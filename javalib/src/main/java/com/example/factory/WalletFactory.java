package com.example.factory;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/08
 * desc   : 成立钱包厂
 * version: 1.0
 */
public class WalletFactory extends BagFactory03{
    @Override
    public Product createProduct() {
        return new Wallet();
    }
}
