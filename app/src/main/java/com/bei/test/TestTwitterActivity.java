package com.bei.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/05/24
 * desc   :
 * version: 1.0
 */
public class TestTwitterActivity extends Activity implements View.OnClickListener {
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main09);
        ButterKnife.bind(this);

        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                //android 系统浏览器打开
                //https://twitter.com/PROFILENAME
                String url = "https://twitter.com/bbcstories";
                opTwitter(url);

                break;
            case R.id.button5:
                //twitter://user?user_id=USERID
                // 链接 app 打开
                String url02 = "twitter://user?user_id=14697685";
                opTwitter(url02);
                break;
            default:
                break;
        }
    }

    private boolean opTwitter(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
        return true;
    }

}
