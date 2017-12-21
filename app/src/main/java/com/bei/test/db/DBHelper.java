package com.bei.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/20
 * desc   : 数据库管理类
 * version: 1.0
 */
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_fav (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS table_fav");
        onCreate(db);

    }
}
