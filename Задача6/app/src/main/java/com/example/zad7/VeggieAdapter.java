package com.example.zad7;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VeggieAdapter extends RecyclerView.Adapter<VeggieViewHolder> {

    private List<Veggie> items;
    private Context context;

    public VeggieAdapter(List<Veggie> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public VeggieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View veggieView = inflater.inflate(R.layout.veggie_item, parent, false);

        VeggieViewHolder viewHolder = new VeggieViewHolder((veggieView));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VeggieViewHolder holder, int position) {
        Veggie veggie = items.get(position);
        holder.setName(veggie.getName());
        holder.setPrice(veggie.getPrice());
        holder.setAmount(veggie.getAmount());
        holder.setSugaryIndex(veggie.getSugary_index());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, view.class);
                intent.putExtra("veggie", veggie);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Veggie getItem(int at) {
        return items.get(at);
    }
}