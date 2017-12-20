package com.bei.test;

import android.content.Intent;
import android.os.Bundle;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/14
 * desc   :
 * version: 1.0
 */
public class MainActivity09 extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        //TODO
    }

    @Override
    public void initView() {
        //TODO

        Intent intent = new Intent(MainActivity09.this,MainActivity08.class);
        startActivity(intent);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
