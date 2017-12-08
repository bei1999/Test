package com.example.factory;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/08
 * desc   :
 * version: 1.0
 */
public class Test  {
    public static void main(String[] agrs){
        BagFactory bagFactory = new BagFactory();
        Product product = bagFactory.productBag("wallet");
        product.makePackage();


        //批量生产钱包
       Product wallet = BagFactory02.createProduct(Wallet.class);
       wallet.makePackage();

       //单一职责，分厂生产不同类型
       WalletFactory walletFactory = new WalletFactory();
       Product product02 = walletFactory.createProduct();
       product02.makePackage();


    }
}
