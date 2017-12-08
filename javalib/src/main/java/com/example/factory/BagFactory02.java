package com.example.factory;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/08
 * desc   : 江南皮革厂
 * version: 1.0
 */
public class BagFactory02 {

    public static <T extends Product> T createProduct(Class<T> clz){
        Product product=null;
        try {
            product=(Product) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;

    }

}
