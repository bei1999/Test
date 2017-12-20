package com.bei.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/20
 * desc   :
 * version: 1.0
 */
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DB_TEST", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_fav (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age TEXT)");
        db.execSQL("INSERT INTO table_fav(name,age) values ('lilei','18')");
        db.execSQL("INSERT INTO table_fav(name,age) values ('hanmeimei','17')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
