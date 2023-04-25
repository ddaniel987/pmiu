package com.example.pmiu4_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmiu4_.databinding.Activity2Binding;
import com.example.pmiu4_.Person;
public class Activity2 extends AppCompatActivity {

    private Activity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView nameShow = findViewById(R.id.textView2);
        nameShow.setText(name);

        Button buttonNext = findViewById(R.id.button3);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer age = Integer.parseInt((((EditText)findViewById(R.id.editTextNumber)).getText().toString()));
                String address = ((EditText)findViewById(R.id.editTextTextPersonName2)).getText().toString();
                String city = ((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString();
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                person.setAddress(address);
                person.setCity(city);

                Intent newIntent = new Intent(Activity2.this, Activity3.class);
                newIntent.putExtra("person", person);
                startActivity(newIntent);
            }
        });

        Button buttonBack = findViewById(R.id.button2);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}