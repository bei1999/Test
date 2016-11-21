package com.bei.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.util.Log;
import android.view.View;

import com.bei.test.utils.Url;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bei.test.BuildConfig.API_SERVICE_URL;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.go_permission_bt)
    Button goPermissionBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                break;
        }

        String url = Url.getHost();
        Log.d("bei",url);

    }
}
