package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bei.test.bean.DataResponse;
import com.bei.test.engine.ApiService;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lizhanbei on 17/1/8.
 * test https
 */
public class MainActivity06 extends Activity {
    @Bind(R.id.button3)
    Button mButton3;
    @Bind(R.id.show_tv)
    TextView mShowTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);
        ButterKnife.bind(this);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requestNetWork();
            }
        });

    }

    private void requestNetWork() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<DataResponse> response = service.getList();
        response.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (null != response){
                    Logger.d(response.body().getStatus());
                    mShowTv.setText(response.body().getStatus()+"");
                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });

    }
}
