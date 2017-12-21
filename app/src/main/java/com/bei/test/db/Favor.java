package com.bei.test.db;

import android.net.Uri;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/21
 * desc   : 常量
 * version: 1.0
 */
public class Favor {
    public static final String AUTHORITY = "com.bei.test.db.DataProvider";
    public static final String PATH = "table_fav";
    public static final String CONTENT_URL_STRING = "content://" +AUTHORITY +"/"+PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URL_STRING);
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
}
