package com.bei.test.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/20
 * desc   : 对外提供数据接口类
 * version: 1.0
 */
public class DataProvider extends ContentProvider {

    private DBHelper mDBHelper;
    private static final String DB_NAME = "favor.db";
    private static final String DB_TABLE = "table_fav";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        mDBHelper = new DBHelper(getContext(), DB_NAME, null, DB_VERSION);
        db = mDBHelper.getWritableDatabase();
        if (db == null) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
//        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        return db.query(DB_TABLE, projection, null, null, null, null, null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long id = db.insert(DB_TABLE,null,values);
        if (id > 0) {
            Uri newUri = ContentUris.withAppendedId(Favor.CONTENT_URI,id);
            getContext().getContentResolver().notifyChange(newUri,null);
            return newUri;
        }
        throw  new SQLException("failed to insert row into" +uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
