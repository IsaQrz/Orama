package com.example.desafioorama.App;

import com.example.desafioorama.viewmodel.mainViewModel.MainViewModelFactory;
import com.example.desafioorama.repository.APIService;
import com.example.desafioorama.repository.FundLocalDataSource;
import com.example.desafioorama.repository.FundRemoteDataSource;
import com.example.desafioorama.repository.FundRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppContainer {
    private static String Base_URL = "https://s3.amazonaws.com/orama-media/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private APIService apiService = retrofit.create(APIService.class);

    private FundRemoteDataSource remoteDataSource = new FundRemoteDataSource(retrofit, apiService);
    private FundLocalDataSource localDataSource = new FundLocalDataSource();

    public FundRepository fundRepository = new FundRepository(localDataSource, remoteDataSource);
    public MainViewModelFactory mainViewModelFactory = new MainViewModelFactory(fundRepository);
}
