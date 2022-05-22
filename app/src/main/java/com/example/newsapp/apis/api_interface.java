package com.example.newsapp.apis;


import com.example.newsapp.modelclasses.Root;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface api_interface {




    @GET("top-headlines")
    Call<Root> getheadlines(@Query("country") String country,@Query("apiKey") String api_key,@Query("pageSize") int page_size);

    @GET("top-headlines")
    Call<Root> getheadlines(@Query("country") String country,@Query("category") String catagory,@Query("apiKey") String api_key,@Query("pageSize") int page_size);


}
