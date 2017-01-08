package com.bei.test.engine;

import com.bei.test.bean.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lizhanbei on 17/1/8.
 */
public interface ApiService {

    @GET("keeplive/")
    Call<DataResponse> getList();
}
