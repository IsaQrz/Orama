package com.example.desafioorama.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioorama.App.AppContainer;
import com.example.desafioorama.App.MyApplication;
import com.example.desafioorama.R;
import com.example.desafioorama.adapter.CardListener;
import com.example.desafioorama.adapter.Adapter;
import com.example.desafioorama.databinding.ActivityMainBinding;
import com.example.desafioorama.models.FundInformation;
import com.example.desafioorama.viewmodel.mainViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardListener{

    private List<FundInformation> listFunds = new ArrayList<>();

    private AppContainer appContainer;
    private MainViewModel mainViewModel;

    ActivityMainBinding binding;
    private Adapter adapterList;

    private RecyclerView recyclerView;
    private TextView empty;
    private ProgressBar progressBar;
    private EditText searchText;

    private ArrayList<String> selectedFilters = new ArrayList<>();
    private String currentSearchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        empty = binding.emptyList;
        recyclerView = binding.recyclerview;
        progressBar = binding.progressBar;
        searchText = binding.searchEditText;

        settingEditText();
        settingChips();
        showProgressBar();
        createAdapter();

        createViewModel();
        observableListFunds();
        getListAllFunds();

    }


    private void settingEditText(){
        searchText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentSearchText = String.valueOf(s);
                ArrayList<FundInformation> filteredFunds = new ArrayList<>();
                for(FundInformation item: listFunds)
                {
                    if(item.getFullName().toLowerCase().contains(String.valueOf(s).toLowerCase()))
                    {
                        if(selectedFilters.size()==0 ||selectedFilters.size()==3)
                        {
                            filteredFunds.add(item);
                        }
                        else
                        {
                            for(String filter: selectedFilters)
                            {
                                if (item.getSpecification().getFundMacroStrategy().getName().toLowerCase().contains(filter))
                                {
                                    filteredFunds.add(item);
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
        });
        searchText.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() >= (searchText.getRight() - searchText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if(searchText.isFocused()){
                        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                                searchText.getWindowToken(), 0);
                    }
                    return true;
                }
            }
            return false;
        });

    }
    public void settingChips() {
        binding.chipFixInc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                filterListChips("renda fixa");
            } else {
                selectedFilters.remove("renda fixa");
                filterCheck();
            }
        });
        binding.chipDifStrat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                filterListChips("estratégias diferenciadas");
            } else {
                selectedFilters.remove("estratégias diferenciadas");
                filterCheck();

            }
        });
        binding.chipVarInc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                filterListChips("renda variável");
            } else {
                selectedFilters.remove("renda variável");
                filterCheck();
            }
        });
    }
    private void createAdapter(){
        adapterList = new Adapter(this,listFunds,this);
    }

    private void createViewModel(){
        appContainer = ((MyApplication) getApplication()).appContainer;
        mainViewModel = appContainer.mainViewModelFactory.create();
    }

    private void observableListFunds(){
        mainViewModel.getListFundsObserver().observe(this, completeFunds -> {
            if (completeFunds != null){
                listFunds = completeFunds;
                hideEmptyListText();
                hideProgressBar();
                adapterList.setList(completeFunds);
                recyclerView.setAdapter(adapterList);
            } else{
                showEmptyListText();
                hideProgressBar();
            }
        });

    }
    private void showEmptyListText(){
        empty.setVisibility(View.VISIBLE);
    }
    private void hideEmptyListText(){
        empty.setVisibility(View.GONE);
    }
    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
    private void getListAllFunds(){
        mainViewModel.getListFunds();
    }

    @Override
    public void onCardClick(FundInformation fund) {
        Intent detailInt = new Intent(this, DetailActivity.class);
        detailInt.putExtra("fund", fund);
        startActivity(detailInt);
    }



    private void filterListChips(String status)
    {
        if(status != null && !selectedFilters.contains(status))
            selectedFilters.add(status);

        ArrayList<FundInformation> filteredFunds = new ArrayList<>();

        for(FundInformation item: listFunds)
        {
            for(String filter: selectedFilters)
            {
                if(item.getSpecification().getFundMacroStrategy().getName().toLowerCase().contains(filter))
                {
                    if(currentSearchText == "")
                    {
                        filteredFunds.add(item);
                    }
                    else
                    {
                        checkNameSearch(item,filteredFunds);
                    }
                }
            }
        }

        adapterList.setList(filteredFunds);
    }
    private void filterCheck()
    {
        if(selectedFilters.size()==0 || selectedFilters.size()==3)
        {
            if(currentSearchText.equals(""))
            {
                adapterList.setList(listFunds);
            }
            else
            {
                ArrayList<FundInformation> filteredFunds = new ArrayList<>();
                for(FundInformation item: listFunds) {
                    checkNameSearch(item,filteredFunds);
                }
                adapterList.setList(filteredFunds);
            }
        }
        else
        {
            filterListChips(null);
        }
    }

    private void checkNameSearch(FundInformation item,ArrayList<FundInformation> filteredFunds ){
        if(item.getFullName().toLowerCase().contains(currentSearchText.toLowerCase()))
        {
            filteredFunds.add(item);
        }
    }

}