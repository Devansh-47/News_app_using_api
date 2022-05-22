package com.example.newsapp.apis;



import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiclient {
    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){

        if(retrofit==null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
            retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();

        }
        return retrofit;
    }
}
