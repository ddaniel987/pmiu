package com.example.pmiu4_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Person person = getIntent().getParcelableExtra("person", Person.class);
        ((TextView)findViewById(R.id.textView5)).setText(person.getName());
        ((TextView)findViewById(R.id.textView6)).setText(person.getAge().toString());
        ((TextView)findViewById(R.id.textView10)).setText(person.getAddress());
        ((TextView)findViewById(R.id.textView12)).setText(person.getCity());

        Button buttonBack = findViewById(R.id.button4);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });

    }
}