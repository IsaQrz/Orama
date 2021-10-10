package com.example.desafioorama.viewmodel.mainViewModel;
import com.example.desafioorama.repository.FundRepository;


public class MainViewModelFactory implements IMainViewModelFactory
{
    private final FundRepository fundRepository;

    public MainViewModelFactory(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @Override
    public MainViewModel create() {

        return new MainViewModel(fundRepository);
    }
}
