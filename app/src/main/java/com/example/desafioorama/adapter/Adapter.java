package com.example.desafioorama.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioorama.R;
import com.example.desafioorama.databinding.CustomCardBinding;
import com.example.desafioorama.models.CompleteFund;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {

    private LayoutInflater layoutInflater;
    private List<CompleteFund> fundData;
    private Context context;
    private CardListener cardClick;

    public Adapter(Context context, List<CompleteFund> data, CardListener cardClick){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.fundData = data;
        this.cardClick=cardClick;
    }
    public void setList(List<CompleteFund> list){
        if(fundData!=null){
            fundData.clear();
        }
        fundData.addAll(list);
        this.notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_card,parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        String category = fundData.get(position).getSpecification().getFundMacroStrategy().getName();
        holder.fundCategory.setText(category);
        Log.d("categoria adapter", String.valueOf(fundData.get(position).getSpecification().getFundMacroStrategy().getName()));
        String subcategory = fundData.get(position).getSpecification().getFundMainStrategy().getName();
        holder.fundSubCategory.setText(subcategory);

        String name = fundData.get(position).getSimpleName();
        holder.fundName.setText(name);

        String profitability = fundData.get(position).getProfitabilities().getMonth();
        Float porcent = Float.valueOf(profitability) *100;
        holder.fundProfit.setText(String.format("%.02f", porcent));

        String date = fundData.get(position).getQuotaDate();
        holder.fundDate.setText(date);
        if(date !=null){
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
            Log.d("data", String.valueOf(dt));
            try {
                Date dateBefore = dt.parse(date);
                SimpleDateFormat dtFmt = new SimpleDateFormat("dd/mm/yyyy");
                holder.fundDate.setText(dtFmt.format(dateBefore));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        String initialApplication = fundData.get(position).getOperability().getMinimumInitialApplicationAmount();
        holder.fundMinApplication.setText(initialApplication);

        String daysRetrieval = fundData.get(position).getOperability().getRetrievalQuotationDaysStr();
        holder.fundDaysRetrieval.setText(daysRetrieval);

        int risk = fundData.get(position).getSpecification().getFundRiskProfile().getScoreRangeOrder();

        switch(risk){
            case 1:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.blue_level1));
                break;
            case 2:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.blue_level2));
                break;
            case 3:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.green_level1));
                break;
            case 4:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.green_level2));
                break;
            case 5:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.green_level3));
                break;
            case 6:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.yellow_level1));
                break;
            case 7:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.yellow_level2));
                break;
            case 8:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.orange_level1));
                break;
            case 9:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.orange_level2));
                break;
            case 10:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.orange_level3));
                break;
            case 11:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.red_level1));
                break;
            case 12:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.red_level2));
                break;
            default:
                holder.cardView.setCardBackgroundColor(context.getColor(R.color.white));
                break;
        }

        holder.cardViewInternal.setOnClickListener(v -> {

            cardClick.onCardClick(fundData.get(position));
        });

    }


    @Override
    public int getItemCount() {
        Log.d("size", String.valueOf(fundData.size()));
        try {
            return fundData.size();
        } catch (Exception ex){return 0;}

    }


    public class ListViewHolder extends RecyclerView.ViewHolder{

        TextView fundCategory;
        TextView fundSubCategory;
        TextView fundName;
        TextView fundProfit;
        TextView fundDate;
        TextView fundMinApplication;
        TextView fundDaysRetrieval;
        CardView cardView;
        CardView cardViewInternal;

        public ListViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            cardViewInternal = itemView.findViewById(R.id.cardview_internal);
            fundCategory =  itemView.findViewById(R.id.category_fund);
            fundSubCategory =  itemView.findViewById(R.id.subcategory_fund);
            fundName =  itemView.findViewById(R.id.fund_name);
            fundProfit =  itemView.findViewById(R.id.fund_profitability);
            fundDate =  itemView.findViewById(R.id.date_fund);
            fundMinApplication =  itemView.findViewById(R.id.min_application);
            fundDaysRetrieval =  itemView.findViewById(R.id.days_retrieval);

        }
    }
}
