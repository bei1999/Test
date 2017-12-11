package com.example.adapter;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/11
 * desc   : usb hub 兼容2.0，3.0
 * version: 1.0
 */
public class USBHubAdpter implements HubActionI{
    private USB2 usb2;
    private USB3 usb3;


    public USBHubAdpter(USB2 usb2,USB3 usb3) {
        usb2 = usb2;
    }
    @Override
    public void tranferByTwo() {
        usb2.tranferByTwo();

    }

    @Override
    public void tranferByThree() {
        usb3.tranferThree();

    }
}
