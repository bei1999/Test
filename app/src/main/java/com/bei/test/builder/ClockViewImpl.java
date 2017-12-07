package com.bei.test.builder;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/07
 * desc   : 表盘实现类
 * version: 1.0
 */
public class ClockViewImpl extends ClockView {
    private float mTextSize; //文字大小

    public ClockViewImpl(Context context) {
        super(context);
    }

    public ClockViewImpl(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void paint(Canvas canvas) {
        //todo 绘制表盘
    }

    public static class BuilderImpl extends Builder {
        private Context context;
        private float textSize; //文字大小

        public BuilderImpl(Context context) {
            this.context = context;
        }

        @Override
        public Builder setRadius(float radius) {
            return this;
        }

        @Override
        public Builder setTextSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        @Override
        public Builder setBackgroundColor(int backgroundColor) {
            return this;
        }

        @Override
        public Builder setPadding(float padding) {
            return this;
        }

        @Override
        public ClockViewImpl create() {
            ClockViewImpl clockView = new ClockViewImpl(context);
            clockView.mTextSize  = textSize;

            return clockView;
        }
    }
}
