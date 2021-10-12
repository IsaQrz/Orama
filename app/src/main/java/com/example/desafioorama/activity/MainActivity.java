package com.example.desafioorama.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.desafioorama.App.AppContainer;
import com.example.desafioorama.App.MyApplication;
import com.example.desafioorama.R;
import com.example.desafioorama.adapter.CardListener;
import com.example.desafioorama.adapter.Adapter;
import com.example.desafioorama.databinding.ActivityMainBinding;
import com.example.desafioorama.models.FundInformation;
import com.example.desafioorama.utils.CreateTextChangedListener;
import com.example.desafioorama.viewmodel.mainViewModel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardListener, AdapterView.OnItemSelectedListener {

    private ArrayList<FundInformation> listFunds = new ArrayList<>();

    private AppContainer appContainer;
    private MainViewModel mainViewModel;

    ActivityMainBinding binding;
    private Adapter adapterList;
    private CreateTextChangedListener createTextChangedListener;

    private RecyclerView recyclerView;
    private TextView empty;
    private ProgressBar progressBar;
    private EditText searchText;
    private SwipeRefreshLayout swipeRefresh;
    private Spinner spinner;

    private ArrayList<String> selectedFilters = new ArrayList<>();
    private int spinnerPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        empty = binding.emptyList;
        recyclerView = binding.recyclerview;
        progressBar = binding.progressBar;
        searchText = binding.searchEditText;
        swipeRefresh = binding.swipeRefresh;
        spinner = binding.spinnerOptions;

        settingSwiper();
        settingSpinner();
        showProgressBar();
        createAdapter();

        createViewModel();
        observableListFunds();
        getListAllFunds();

        settingEditText();
        settingChips();

    }

    private void settingSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void settingSwiper() {
        swipeRefresh.setOnRefreshListener(() -> {
            getListAllFunds();
            swipeRefresh.setRefreshing(false);
            showProgressBar();
        });
    }


    private void settingEditText() {
        searchText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchText.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (searchText.getRight() - searchText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if (searchText.isFocused()) {
                        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                                searchText.getWindowToken(), 0);
                    }
                    return true;
                }
            }
            return false;
        });
        createTextChangedListener = new CreateTextChangedListener(listFunds, selectedFilters, adapterList, spinnerPosition);
        searchText.addTextChangedListener(createTextChangedListener);
    }


    private void createAdapter() {
        adapterList = new Adapter(this, listFunds, this);
    }

    private void createViewModel() {
        appContainer = ((MyApplication) getApplication()).appContainer;
        mainViewModel = appContainer.mainViewModelFactory.create();
        mainViewModel.setContext(this);
        mainViewModel.setView(binding.getRoot());
    }

    private void observableListFunds() {
        mainViewModel.getListFundsObserver().observe(this, completeFunds -> {
            if (completeFunds != null && completeFunds.size()!=0) {
                listFunds = completeFunds;
                hideEmptyListText();
                hideProgressBar();
                adapterList.setList(completeFunds);
                recyclerView.setAdapter(adapterList);
                swipeRefresh.setRefreshing(false);
                mainViewModel.saveCache(completeFunds);
                createTextChangedListener.setListFunds(completeFunds);

            } else {
                showEmptyListText();
                hideProgressBar();
            }
        });

    }

    private void showEmptyListText() {
        recyclerView.setVisibility(View.GONE);
        empty.setVisibility(View.VISIBLE);
    }

    private void hideEmptyListText() {
        empty.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void getListAllFunds() {
        mainViewModel.getListFunds();
    }


    public void settingChips() {
        binding.chipFixInc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.fixed_income).toLowerCase());
        });
        binding.chipDifStrat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.dif_strategy).toLowerCase());
        });
        binding.chipVarInc.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.variable_income).toLowerCase());
        });
        binding.chipConservative.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.profile_conservative).toLowerCase());
        });
        binding.chipModerate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.profile_moderate).toLowerCase());
        });
        binding.chipDashing.setOnCheckedChangeListener((buttonView, isChecked) -> {
            chipCheck(isChecked,getString(R.string.profile_dashing).toLowerCase());
        });
    }

    private void chipCheck(Boolean isChecked, String chipName ){
        if (isChecked) {
            filterListChips(chipName);
        } else {
            selectedFilters.remove(chipName);
            filterCheck();
        }
    }

    private void filterListChips(String status) {
        if (status != null && !selectedFilters.contains(status))
            selectedFilters.add(status);

        ArrayList<FundInformation> filteredFunds = new ArrayList<>();

        for (FundInformation item : listFunds) {
            for (String filter : selectedFilters) {
                if (spinnerPosition == 0) {
                    if (item.getSpecification().getFundMacroStrategy().getName().toLowerCase().contains(filter)) {
                        checkNameString(item, filteredFunds);
                    }
                } else if (spinnerPosition == 1) {
                    if (item.getSpecification().getFundSuitabilityProfile().getName().toLowerCase().contains(filter)) {
                        checkNameString(item, filteredFunds);
                    }
                }
            }
        }
        adapterList.setList(filteredFunds);
    }

    private void filterCheck() {
        if (selectedFilters.size() == 0 || selectedFilters.size() == 3) {
            if (createTextChangedListener.getCurrentSearchText().equals("")) {
                adapterList.setList(listFunds);
            } else {
                ArrayList<FundInformation> filteredFunds = new ArrayList<>();
                for (FundInformation item : listFunds) {
                    checkNameSearch(item, filteredFunds);
                }
                adapterList.setList(filteredFunds);
            }
        } else {
            filterListChips(null);
        }
    }

    private void checkNameString(FundInformation item, ArrayList<FundInformation> filteredFunds) {
        if (createTextChangedListener.getCurrentSearchText() == "") {
            filteredFunds.add(item);
        } else {
            checkNameSearch(item, filteredFunds);
        }
    }

    private void checkNameSearch(FundInformation item, ArrayList<FundInformation> filteredFunds) {
        if (item.getFullName().toLowerCase().contains(createTextChangedListener.getCurrentSearchText().toLowerCase())) {
            filteredFunds.add(item);
        }
    }

    @Override
    public void onCardClick(FundInformation fund) {
        Intent detailInt = new Intent(this, DetailActivity.class);
        detailInt.putExtra("fund", fund);
        startActivity(detailInt);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (spinnerPosition != position) {
            selectedFilters.clear();
            binding.chipDashing.setChecked(false);
            binding.chipDashing.setChecked(false);
            binding.chipConservative.setChecked(false);
            binding.chipFixInc.setChecked(false);
            binding.chipDifStrat.setChecked(false);
            binding.chipVarInc.setChecked(false);
        }
        if (position == 0) {
            binding.linearLayoutStrategy.setVisibility(View.VISIBLE);
            binding.linearLayoutProfile.setVisibility(View.GONE);
        } else if (position == 1) {
            binding.linearLayoutProfile.setVisibility(View.VISIBLE);
            binding.linearLayoutStrategy.setVisibility(View.GONE);
        }
        spinnerPosition = position;
        createTextChangedListener.setPosition(spinnerPosition);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}