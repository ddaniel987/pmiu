package com.example.zad7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Veggie veggie = getIntent().getParcelableExtra("veggie", Veggie.class);

        ((TextView)findViewById(R.id.textView10)).setText(veggie.getName());
        ((TextView)findViewById(R.id.textView12)).setText(veggie.getPrice().toString());
        ((TextView)findViewById(R.id.textView14)).setText(veggie.getAmount().toString());
        ((TextView)findViewById(R.id.textView16)).setText(veggie.getSugary_index().toString());

        Button back = findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}