package com.example.desafioorama.viewmodel.mainViewModel;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.desafioorama.R;
import com.example.desafioorama.models.FundInformation;
import com.example.desafioorama.repository.FundRepository;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<FundInformation>> listFundsResponse;
    private FundRepository repository;
    private Context context;
    private View view;

    public MainViewModel(FundRepository repository) {
        listFundsResponse = new MutableLiveData<>();
        this.repository = repository;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setView(View view) {
        this.view = view;
    }

    public MutableLiveData<ArrayList<FundInformation>> getListFundsObserver() {
        return listFundsResponse;
    }

    public void getListFunds() {

        Call<ArrayList<FundInformation>> call = repository.getAllFunds();
        call.enqueue(new Callback<ArrayList<FundInformation>>() {
            @Override
            public void onResponse(Call<ArrayList<FundInformation>> call, Response<ArrayList<FundInformation>> response) {
                listFundsResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<FundInformation>> call, Throwable t) {
                listFundsResponse.postValue(null);
                Log.d("ERROR", String.valueOf(t));
                showListFromCache();


            }
        });

    }

    private void showListFromCache() {
        Snackbar snackbar = Snackbar
                .make(view, context.getString(R.string.list_cache), Snackbar.LENGTH_LONG);
        snackbar.show();
        ArrayList<FundInformation> listCache = (ArrayList<FundInformation>) getCache();
        listFundsResponse.postValue(listCache);
    }

    public void saveCache(ArrayList<FundInformation> listFunds) {
        repository.saveCacheListFunds(context, listFunds);

    }

    public List<FundInformation> getCache() {
        return repository.getCacheListFunds(context);
    }


}
