//package com.bei.test;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.drawable.GlideDrawable;
//import com.bumptech.glide.request.RequestListener;
//import com.bumptech.glide.request.target.Target;
//
///**
// * Created by lizhanbei on 17/1/10.
// */
//
//public class TestImage extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_image);
//        ImageView img = (ImageView) findViewById(R.id.img_ic);
//        //baidu https://ss1.bdstatic.com/lvoZeXSm1A5BphGlnYG/skin/44.jpg
//        Glide.with(this).load("https://newstest.cgtn.com/news/3d3d414d77636a4e/img/69ef15d7-7db8-4041-a9aa-6590a60a0f1a.jpg").listener(new RequestListener<String, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, String s, Target<GlideDrawable> target, boolean b) {
//                Log.d("bei","加载失败"+e);
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable glideDrawable, String s, Target<GlideDrawable> target, boolean b, boolean b1) {
//                Log.d("bei","成功加载");
//                return false;
//            }
//        }).into(img);
//        //https://newstest.cgtn.com/news/3d3d414d77636a4e/img/69ef15d7-7db8-4041-a9aa-6590a60a0f1a.jpg
////        Glide.with(this).load("https://newstest.cgtn.com/news/3d3d414d77636a4e/img/69ef15d7-7db8-4041-a9aa-6590a60a0f1a.jpg").into(img);
//    }
//}
