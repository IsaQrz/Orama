package com.example.desafioorama.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitService {

    public static String Base_URL = "https://s3.amazonaws.com/orama-media/";


    private static Retrofit retrofit;

    public static Retrofit getClient(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)


                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }

    public static APIService createService(){
        APIService apiService = RetrofitService.getClient()
                .create(APIService.class);
        return apiService;
    }





}
