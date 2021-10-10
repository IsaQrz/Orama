package com.example.desafioorama.repository;

import retrofit2.Retrofit;

public class FundRemoteDataSource {

    private final Retrofit retrofit;
    private APIService apiService;

    public FundRemoteDataSource(Retrofit retrofit, APIService apiService) {
        this.retrofit = retrofit;
        this.apiService = apiService;
    }

    public APIService getApiService() {
        return apiService;
    }
}
