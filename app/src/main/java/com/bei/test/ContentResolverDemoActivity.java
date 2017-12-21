package com.bei.test;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bei.test.db.Favor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/12/20
 * desc   : 测试类
 * version: 1.0
 */
public class ContentResolverDemoActivity extends Activity {
    private static final String[] PROJECTION = new String[]{"name", "age"};
    @Bind(R.id.nameTv)
    EditText nameTv;
    @Bind(R.id.ageTv)
    EditText ageTv;
    @Bind(R.id.addBtn)
    Button addBtn;
    @Bind(R.id.queryBtn)
    Button queryBtn;
    @Bind(R.id.resultTv)
    TextView resultTv;
    @Bind(R.id.resultUrl)
    TextView resultUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main09);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.addBtn, R.id.queryBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addBtn:
                ContentValues contentValues = new ContentValues();
                contentValues.put(Favor.KEY_NAME, nameTv.getText().toString());
                contentValues.put(Favor.KEY_AGE, ageTv.getText().toString());

                Uri newUrl = this.getContentResolver().insert(Favor.CONTENT_URI, contentValues);

                resultUrl.setText("添加成功 ，URI:" + newUrl);

                break;
            case R.id.queryBtn:
                Cursor cursor = getContentResolver().query(Favor.CONTENT_URI, PROJECTION, null, null, null);
                String msg = "";
                cursor.moveToFirst();
                do {
                    msg += "name: " + cursor.getString(0);
                    msg += "age: " + cursor.getString(1)+"\n";


                } while (cursor.moveToNext());
                cursor.close();

                resultTv.setText(msg);

                break;
        }
    }
}
