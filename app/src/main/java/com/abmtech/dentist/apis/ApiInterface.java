package com.abmtech.dentist.apis;

import com.abmtech.dentist.firebase.NotiModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {



    @POST("send")
    Call<NotiModel> sendNotification(
            @Header("Authorization") String key,
            @Header("Content-Type") String contentType,
            @Body Map<String, Object> body
    );


}
