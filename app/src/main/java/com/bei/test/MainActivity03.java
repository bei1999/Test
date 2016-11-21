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

public class MainActivity03 extends AppCompatActivity {

    @Bind(R.id.img01)
    ImageView img01;
    @Bind(R.id.newsInfoScrollView)
    ObservableScrollView newsInfoScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);

        newsInfoScrollView.setScrollListener(new ObservableScrollView.ScrollListener() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void scrollOritention(int oritention) {
                if (oritention == ObservableScrollView.SCROLL_UP){
                    showPlayer(false);
                }else {
                    showPlayer(true);
                }
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
