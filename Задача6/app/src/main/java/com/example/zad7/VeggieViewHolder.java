package com.example.zad7;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VeggieViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView price;
    private TextView amount;
    private TextView sugar_index;

    public VeggieViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textView);
        price = itemView.findViewById(R.id.textView2);
        amount = itemView.findViewById(R.id.textView3);
        sugar_index = itemView.findViewById(R.id.textView4);
    }

    public TextView getName() {
        return name;
    }

    public TextView getPrice() {
        return price;
    }

    public TextView getAmount() {
        return amount;
    }

    public TextView getSugaryIndex() {
        return sugar_index;
    }


    public void setName(String name) {
        this.name.setText(name);
    }

    public void setPrice(Double price) {
        this.price.setText(String.format("%.2f", price));
    }

    public void setAmount(Double amount) {
        this.amount.setText(String.format("%.2f", amount));
    }

    public void setSugaryIndex(Double sugaryIndex) {
        this.sugar_index.setText(String.format("%.2f", sugaryIndex));
    }
}