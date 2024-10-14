package com.example.call_api_hk.api;

import com.example.call_api_hk.adapter.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyy").create();
    ApiService apiService = new Retrofit. Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("posts")
    Call<List<User>> getListUsers(@Query("userId") int userId);

    //kkkkkk
}

