package com.example.desafioorama;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.desafioorama.models.CompleteFund;
import com.example.desafioorama.repository.APIService;
import com.example.desafioorama.repository.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<CompleteFund>> listFunds;

    public MainViewModel(){
        listFunds = new MutableLiveData<>();
    }

    public MutableLiveData<List<CompleteFund>> getListObserver(){
        return listFunds;
    }

    public void getFromAPI(){
        APIService service = RetrofitService.createService();
        Call<List<CompleteFund>> call = service.getAllFunds();
        call.enqueue(new Callback<List<CompleteFund>>() {
            @Override
            public void onResponse(Call<List<CompleteFund>> call, Response<List<CompleteFund>> response) {
                listFunds.postValue(response.body());
                Log.d("RESPOSTA", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<List<CompleteFund>> call, Throwable t) {
                listFunds.postValue(null);
                Log.d("ERRO", String.valueOf(t));
            }
        });

    }


}
