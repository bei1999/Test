package com.bei.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by lzb on 16/11/8.
 */

public class NewsinfoScrollView extends ScrollView {
    private OnScrollListener onScrollListener;
    private float lastX = 0;
    private float lastY = 0;
    private boolean isUp = false;

    public NewsinfoScrollView(Context context) {
        super(context, null);
    }

    public NewsinfoScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public NewsinfoScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置滚动接口
     *
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        float x = ev.getX();
        float y = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                lastX = x;
                break;
            case MotionEvent.ACTION_MOVE:
                float dY = Math.abs(y - lastY);
                float dX = Math.abs(x - lastX);
                boolean down = y > lastY ? true : false;
                lastY = y;
                lastX = x;
                isUp = dX < 8 && dY > 8 && !down;
                if (onScrollListener != null) {
                    onScrollListener.onScrollOrientation(isUp);
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);

    }

    public interface OnScrollListener {
        public void onScrollOrientation(boolean isUp);
    }
}
