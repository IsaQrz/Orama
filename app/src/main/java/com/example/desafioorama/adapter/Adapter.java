package com.example.desafioorama.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioorama.R;
import com.example.desafioorama.databinding.CustomCardBinding;
import com.example.desafioorama.models.FundInformation;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder>{

    private LayoutInflater layoutInflater;
    private List<FundInformation> fundData;
    private List<FundInformation> fullListFundData;
    private Context context;
    private CardListener cardClick;

    public Adapter(Context context, List<FundInformation> data, CardListener cardClick){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.fundData = data;
        fullListFundData = new ArrayList<>(fundData);
        this.cardClick=cardClick;
    }

    public List<FundInformation> getFundData() {
        return fundData;
    }

    public void setList(List<FundInformation> list){
        if(fundData!=null){
            fundData.clear();
            fullListFundData.clear();
        }
        fundData.addAll(list);
        fullListFundData.addAll(fundData);
        this.notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_card,parent, false);
        CustomCardBinding itemBinding =
                CustomCardBinding.inflate(layoutInflater, parent, false);
        return new ListViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        FundInformation item = fundData.get(position);
        holder.bind(item);

        String profitability = fundData.get(position).getProfitabilities().getMonth();
        Float porcent = Float.valueOf(profitability) *100;
        holder.binding.fundProfitability.setText(String.format("%.02f", porcent));

        String date = fundData.get(position).getQuotaDate();
        holder.binding.dateFund.setText(date);
        if(date !=null){
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
            try {
                Date dateBefore = dt.parse(date);
                SimpleDateFormat dtFmt = new SimpleDateFormat("dd/mm/yyyy");
                holder.binding.dateFund.setText(dtFmt.format(dateBefore));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        int risk = fundData.get(position).getSpecification().getFundRiskProfile().getScoreRangeOrder();
        //ViewObject estudar
        switch(risk){
            case 1:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.blue_level1));
                break;
            case 2:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.blue_level2));
                break;
            case 3:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.green_level1));
                break;
            case 4:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.green_level2));
                break;
            case 5:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.green_level3));
                break;
            case 6:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.yellow_level1));
                break;
            case 7:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.yellow_level2));
                break;
            case 8:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.orange_level1));
                break;
            case 9:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.orange_level2));
                break;
            case 10:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.orange_level3));
                break;
            case 11:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.red_level1));
                break;
            case 12:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.red_level2));
                break;
            default:
                holder.binding.cardview.setCardBackgroundColor(context.getColor(R.color.white));
                break;
        }

        holder.binding.cardviewInternal.setOnClickListener(v -> {
            cardClick.onCardClick(fundData.get(position));
        });

    }


    @Override
    public int getItemCount() {
        try {
            return fundData.size();
        } catch (Exception ex){return 0;}

    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        CustomCardBinding binding;

        public ListViewHolder(CustomCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FundInformation item) {
            binding.setFund(item);
            binding.executePendingBindings();
        }
    }
}
