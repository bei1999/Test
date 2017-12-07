package com.bei.test.builder;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/07
 * desc   : 表盘
 * version: 1.0
 */

public abstract class ClockView extends View {
    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public abstract void paint(Canvas canvas);
}
