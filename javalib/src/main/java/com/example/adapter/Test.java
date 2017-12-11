package com.example.adapter;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/11
 * desc   : 对象适配器模式
 * version: 1.0
 */
public class Test {


    public static void main(String[] args) {

        USB2 usb2 = new USB2();
        USB3 usb3 = new USB3();
        //构造适配器
        HubActionI hubActionI = new USBHubAdpter(usb2,usb3);
        //2.0传输
        hubActionI.tranferByTwo();
        //3.0传输
        hubActionI.tranferByThree();

    }
}
