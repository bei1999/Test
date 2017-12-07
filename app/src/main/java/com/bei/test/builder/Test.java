package com.bei.test.builder;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bei.test.R;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/07
 * desc   : 主类调用
 * version: 1.0
 */
public class Test extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_view);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.psts_background_tab);
        builder.setMessage("提示");
        AlertDialog dialog = builder.create();
        dialog.show();


        //模仿构造模式
        Builder builder1 = new ClockViewImpl.BuilderImpl(this);
        builder1.setTextSize(12f);
        ClockViewImpl clockViewImpl = builder1.create();


    }
}
