package com.example.desafioorama;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioorama.adapter.CardListener;
import com.example.desafioorama.adapter.Adapter;
import com.example.desafioorama.databinding.ActivityMainBinding;
import com.example.desafioorama.models.CompleteFund;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardListener {

    private List<CompleteFund> listFunds = new ArrayList<>();
    private MainViewModel mainViewModel;
    ActivityMainBinding binding;
    private Adapter adapter;
    private RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        binding = ActivityMainBinding.inflate(layoutInflater);
        TextView empty = binding.emptyList;

        recyclerView = binding.recyclerview;

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,listFunds,this);
        recyclerView.setAdapter(adapter);




        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getListObserver().observe(this, completeFunds -> {
            if (completeFunds != null){
                listFunds = completeFunds;
                adapter.setList(completeFunds);
                empty.setVisibility(View.GONE);



                Log.d("LISTAA", String.valueOf(listFunds.size()));

            } else{
                empty.setVisibility(View.VISIBLE);

            }
        });

        mainViewModel.getFromAPI();

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCardClick(CompleteFund fund) {

    }

}