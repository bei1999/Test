package com.example.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/04
 * desc   : 观察者模式by java api
 * version: 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {

        Sales sales = new Sales();//被观察者
        CustomerA customerA = new CustomerA();//观察者
        sales.addObserver(customerA); //注册
        sales.notifyCustomer("宝马摩托到货啦！！");//通知

    }


    public static class Sales extends Observable {

        public void notifyCustomer(String str) {
            setChanged();
            notifyObservers(str);
        }

    }

    public static class CustomerA implements Observer {

        @Override
        public void update(Observable observable, Object data) {
            if (observable instanceof Sales && data instanceof String) {
                System.out.println((String) data);
            }

        }
    }


}
