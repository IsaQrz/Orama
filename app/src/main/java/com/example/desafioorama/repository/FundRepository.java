package com.example.desafioorama.repository;

import com.example.desafioorama.models.FundInformation;

import java.util.List;

import retrofit2.Call;

public class FundRepository {
    private final FundLocalDataSource fundLocalDataSource;
    private final FundRemoteDataSource fundRemoteDataSource;

    public FundRepository(FundLocalDataSource fundLocalDataSource,
                          FundRemoteDataSource fundRemoteDataSource) {
        this.fundLocalDataSource = fundLocalDataSource;
        this.fundRemoteDataSource = fundRemoteDataSource;
    }

    public Call<List<FundInformation>> getAllFunds(){
        return fundRemoteDataSource.getApiService().getAllFunds();
    }

}
