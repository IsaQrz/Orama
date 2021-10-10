package com.example.desafioorama.viewmodel.mainViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.desafioorama.models.FundInformation;
import com.example.desafioorama.repository.FundRepository;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<FundInformation>> listFundsResponse;
    private FundRepository repository;

    public MainViewModel(FundRepository repository){
        listFundsResponse = new MutableLiveData<>();
        this.repository = repository;
    }


    public MutableLiveData<List<FundInformation>> getListFundsObserver(){
        return listFundsResponse;
    }

    public void getListFunds(){
        Call<List<FundInformation>> call = repository.getAllFunds();
        call.enqueue(new Callback<List<FundInformation>>() {
            @Override
            public void onResponse(Call<List<FundInformation>> call, Response<List<FundInformation>> response) {
                listFundsResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<FundInformation>> call, Throwable t) {
                listFundsResponse.postValue(null);
                Log.d("ERRO", String.valueOf(t));
            }
        });

    }

    public void filterListByStrategy(String textToFilter){


    }
    public void filterListByProfile(){

    }



}
