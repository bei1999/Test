package com.bei.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bei.test.utils.Url;

import static com.bei.test.BuildConfig.API_SERVICE_URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = Url.getHost();
        Log.d("bei",url);

    }
}
