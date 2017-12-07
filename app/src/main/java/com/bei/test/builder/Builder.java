package com.bei.test.builder;
/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/07
 * desc   : build 模式封装参数
 * version: 1.0
 */

public abstract class Builder {

    public abstract Builder setRadius(float radius) ;

    public abstract Builder setTextSize(float textSize) ;

    public abstract Builder setBackgroundColor(int backgroundColor) ;

    public abstract Builder setPadding(float padding) ;


    public abstract ClockViewImpl create() ;
}
