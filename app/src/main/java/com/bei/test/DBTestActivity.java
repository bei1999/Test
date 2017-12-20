package com.bei.test;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/20
 * desc   :
 * version: 1.0
 */
public class DBTestActivity extends Activity{
    public static final String[] PROJECTION = new String[] {"name","age"};
    public static final Uri URI = Uri.parse("content://com.bei.test.db.DataProvider/table_fav");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main09);
       Cursor cursor =  getContentResolver().query(URI,PROJECTION,null,null,null);
       cursor.moveToFirst();
       do {
           System.out.print(cursor.getString(0)+","+cursor.getString(1));
       }while (cursor.moveToNext());
       cursor.close();
    }
}
