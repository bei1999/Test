package com.bei.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.bei.test.view.NewsInfoScrollView;
import com.bei.test.view.ObservableScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity02 extends AppCompatActivity {

    @Bind(R.id.img01)
    ImageView img01;
    @Bind(R.id.newsInfoScrollView)
    NewsInfoScrollView newsInfoScrollView;
    private int lastY = 0;
    private boolean isUp = false;
    private boolean isDown = false;
    boolean mIsTitleHide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        newsInfoScrollView.setOnScrollListener(new NewsInfoScrollView.OnScrollListener() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onScrollOrientation(boolean isUp) {
                showPlayer(isUp ? true : false);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void showPlayer(boolean isShow) {
        if (isShow) {

            float[] f = new float[2];
            f[0] = -img01.getHeight();
            f[1] = 0F;
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(img01, "translationY", f);
            animator1.setInterpolator(new AccelerateDecelerateInterpolator());
            animator1.setDuration(200);
            animator1.start();
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    img01.setVisibility(View.VISIBLE);

                }
            });

        } else {
            Log.d("bei", "gone-----");
            float[] f = new float[2];
            f[0] = 0.0F;
            f[1] = -img01.getHeight();
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(img01, "translationY", f);
            animator1.setInterpolator(new AccelerateDecelerateInterpolator());
            animator1.setDuration(200);
            animator1.start();
            animator1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    img01.setVisibility(View.GONE);

                }
            });
        }

    }
}
