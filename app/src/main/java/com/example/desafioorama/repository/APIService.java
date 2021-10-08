package com.example.desafioorama.repository;


import com.example.desafioorama.models.CompleteFund;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("json/fund_detail_full.json?serializ%20er=fund_detail_full")
    Call<List<CompleteFund>> getAllFunds();

}
