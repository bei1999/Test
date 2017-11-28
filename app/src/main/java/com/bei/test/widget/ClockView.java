package com.bei.test.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bei.test.R;
import com.bei.test.utils.Constants;
import com.bei.test.utils.UiUtils;
import java.util.Calendar;


/**
 * author : lzb
 * e-mail :
 * time   : 2017/11/27
 * desc   : 学习Canvas draw
 * version: 1.0
 */
public class ClockView extends View {
    private static final int DEFAULT_CLOCK_ANIMATION_DURATION = 60 * 1000;
    private static final String DEFAULT_DEFAULT_DIGITAL_TIME_TEXT = "00:00";
    private static final int DEFAULT_DIGITAL_TIME_TEXT_SIZE = 60;
    private int mWidth = 0;
    private int mHeight = 0;
    private Calendar mCalendar;
    public Paint mPaint;
    private Rect mDigitalTimeTextRect;
    private Paint textPaint;
    private String mLastDigitalTimeStr;
    private long mLastTimeMillis;
    private int mTimeTextSize;

    public ClockView(Context context) {
        this(context, null);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context,attrs);
    }

    private void initData(Context context,AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        mTimeTextSize = typedArray.getDimensionPixelSize(R.styleable.ClockView_timeTextSize,
                UiUtils.dipToPx(context, DEFAULT_DIGITAL_TIME_TEXT_SIZE));

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);        // 设置颜色
        textPaint.setStyle(Paint.Style.FILL);   // 设置样式
        textPaint.setTextSize(mTimeTextSize);              // 设置字体大小
        mDigitalTimeTextRect = new Rect();
        textPaint.getTextBounds(DEFAULT_DEFAULT_DIGITAL_TIME_TEXT, 0,
                DEFAULT_DEFAULT_DIGITAL_TIME_TEXT.length(), mDigitalTimeTextRect);
        textPaint.setStrokeWidth(2);
        textPaint.setStrokeCap(Paint.Cap.ROUND);

        mCalendar = Calendar.getInstance();
        mLastDigitalTimeStr = String.format("%02d:%02d", mCalendar.get(Calendar.HOUR),
                mCalendar.get(Calendar.MINUTE));

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;

    }

    public void setStart() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 360);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(DEFAULT_CLOCK_ANIMATION_DURATION);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                long currentTimeMillis = System.currentTimeMillis();
                mCalendar.setTimeInMillis(currentTimeMillis);
                mLastDigitalTimeStr = String.format("%02d:%02d", mCalendar.get(Calendar.HOUR),
                        mCalendar.get(Calendar.MINUTE));
                mLastTimeMillis = currentTimeMillis - mCalendar.get(Calendar.SECOND) * Constants.SECOND
                        - mCalendar.get(Calendar.MILLISECOND);
            }
        });

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        valueAnimator.start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        updateTimeText(canvas);
    }

    private void updateTimeText(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        // Use of abs() func is to prevent the user to adjust the time forward.
        if (Math.abs(currentTimeMillis - mLastTimeMillis) >= Constants.MINUTE) {
            mLastTimeMillis = currentTimeMillis;
            mCalendar.setTimeInMillis(currentTimeMillis);
            mLastDigitalTimeStr = String.format("%02d:%02d",
                    mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE));
        }
        canvas.drawText(mLastDigitalTimeStr, mWidth / 3, mHeight / 2, textPaint);
//        Log.d("bei", "ondraw");

    }

}
