package com.example.zad7;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zad7.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    VeggieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new VeggieAdapter(VeggieSource.generateItemsList(10),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = adapter.getItemCount();
                Random random = new Random();
                for(int i = 0; i < size; i++) {
                    Veggie veggie = adapter.getItem(i);

                    veggie.setPrice(1.0 + random.nextDouble() * 99.0);
                    veggie.setAmount(1.0 + random.nextDouble() * 99.0);
                }

                adapter.notifyDataSetChanged();
                Snackbar.make(view, "Количествата бяха променени.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}