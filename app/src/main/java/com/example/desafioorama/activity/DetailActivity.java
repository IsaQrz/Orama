package com.example.desafioorama.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.desafioorama.R;
import com.example.desafioorama.databinding.ActivityDetailBinding;
import com.example.desafioorama.models.FundInformation;
import com.example.desafioorama.viewmodel.detailViewModel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    FundInformation fund;
    ActivityDetailBinding binding;
    DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fund = (FundInformation) getIntent().getSerializableExtra("fund");

        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        detailViewModel.setFund(fund);
        binding.setViewModel(detailViewModel);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}