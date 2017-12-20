package com.bei.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/14
 * desc   : 基类
 * version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ViewGroup mViewGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewGroup = (ViewGroup) LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(mViewGroup);
    }

    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();

}
