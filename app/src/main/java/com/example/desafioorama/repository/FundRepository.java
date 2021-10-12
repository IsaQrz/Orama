package com.example.desafioorama.repository;

import android.content.Context;
import com.example.desafioorama.models.FundInformation;
import java.util.ArrayList;
import retrofit2.Call;

public class FundRepository {
    private final FundLocalDataSource fundLocalDataSource;
    private final FundRemoteDataSource fundRemoteDataSource;

    public FundRepository(FundLocalDataSource fundLocalDataSource,
                          FundRemoteDataSource fundRemoteDataSource) {
        this.fundLocalDataSource = fundLocalDataSource;
        this.fundRemoteDataSource = fundRemoteDataSource;
    }

    public Call<ArrayList<FundInformation>> getAllFunds() {
        return fundRemoteDataSource.getApiService().getAllFunds();
    }

    public void saveCacheListFunds(Context context, ArrayList<FundInformation> list) {
        fundLocalDataSource.saveCache(context, list);
    }

    public ArrayList<FundInformation> getCacheListFunds(Context context) {
        return fundLocalDataSource.getCache(context);
    }

}
