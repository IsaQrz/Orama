package com.example.desafioorama.viewmodel.detailViewModel;


import androidx.lifecycle.ViewModel;

import com.example.desafioorama.models.FundInformation;

public class DetailViewModel extends ViewModel {

    public FundInformation fund;

    public void setFund(FundInformation fund) {
        this.fund = fund;
    }

    public FundInformation getFund() {
        return fund;
    }
}
