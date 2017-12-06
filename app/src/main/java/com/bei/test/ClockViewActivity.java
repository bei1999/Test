package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bei.test.widget.ClockView;


/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/11/27
 * desc   :
 * version: 1.0
 */
public class ClockViewActivity extends Activity {
    ClockView clockView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_view);

        clockView = (ClockView) findViewById(R.id.clockView);
        clockView.setStart();
    }
}
