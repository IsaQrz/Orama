package com.example.desafioorama.utils;


import android.text.Editable;
import android.text.TextWatcher;

import com.example.desafioorama.adapter.Adapter;
import com.example.desafioorama.models.FundInformation;

import java.util.ArrayList;
import java.util.List;

public class CreateTextChangedListener implements TextWatcher {

    private List<FundInformation> listFunds = new ArrayList<>();
    private ArrayList<String> selectedFilters = new ArrayList<>();
    private Adapter adapterList;
    private String currentSearchText = "";
    private int position;

    public CreateTextChangedListener(List<FundInformation> listFunds, ArrayList<String> selectedFilters,
                                     Adapter adapter, int position) {
        this.listFunds.addAll(listFunds);
        this.selectedFilters = selectedFilters;
        this.adapterList = adapter;
        this.position = position;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    public void setListFunds(List<FundInformation> listFunds) {
        this.listFunds = listFunds;
    }

    public String getCurrentSearchText() {
        return currentSearchText;
    }

    public void setPosition(int position) { this.position = position; }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        currentSearchText = String.valueOf(s);
        ArrayList<FundInformation> filteredFunds = new ArrayList<>();
        for (FundInformation item : listFunds) {
            if (item.getFullName().toLowerCase().contains(String.valueOf(s).toLowerCase())) {
                if (selectedFilters.size() == 0 || selectedFilters.size() == 3) {
                    filteredFunds.add(item);
                } else {
                    for (String filter : selectedFilters) {
                        if( position==0){
                            if (item.getSpecification().getFundMacroStrategy().getName().toLowerCase().contains(filter)) {
                                filteredFunds.add(item);
                            }
                        } else {
                            if (item.getSpecification().getFundSuitabilityProfile().getName().toLowerCase().contains(filter)) {
                                filteredFunds.add(item);
                            }
                        }

                    }
                }
            }
        }
        adapterList.setList(filteredFunds);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}