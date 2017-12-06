package com.example.proxy;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/05
 * desc   : 请代理律师，走起诉流程
 * version: 1.0
 */
public class LawyerProxy implements ActionI {
    private ActionImpl action;

    public LawyerProxy(){
         action = new ActionImpl();
    }
    @Override
    public void qisu() {
        before();
        action.qisu();
        after();
    }

    private void after() {
        System.out.println("等待开庭...");
    }

    private void before() {
        System.out.println("找律师，说明事情经过...");
    }
}
