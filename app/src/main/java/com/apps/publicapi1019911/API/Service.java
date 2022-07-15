package com.apps.publicapi1019911.API;

import com.apps.publicapi1019911.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("api/v1")
    Call<ResponseModel> getAnime();
}
