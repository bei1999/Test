package com.example.observer;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/04
 * desc   : 观察者模式by 接口回调
 * version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Sales<String> sales = new Sales<>();
        Customer customer = new Customer() {
            @Override
            protected void dealWithEvent(String s) {
                System.out.print(s);
            }

        };
        sales.registObserver(customer);
        sales.notifyCustomer("宝马摩托到货啦！");
    }

}
