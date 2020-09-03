package com.example.supersub;

import com.example.supersub.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("drill")
    Call<ResponseData> getJsonData();
}
