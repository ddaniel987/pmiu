package com.example.pmiu4_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmiu4_.databinding.Activity2Binding;
import com.example.pmiu4_.Person;
public class Activity2 extends BaseActivity {

    private Activity2Binding binding;

    public Intent createIntent(Context context) {
        return new Intent(context, Activity3.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        TextView nameShow = findViewById(R.id.textView2);
        nameShow.setText(email);

        //валидация
        EditText phoneField = findViewById(R.id.editTextNumber);
        EditText addyField = findViewById(R.id.editTextTextPersonName2);
        EditText cityField = findViewById(R.id.editTextTextPersonName3);
        EditText nameField = findViewById(R.id.editTextTextPersonName4);

        LengthValidator phoneValidator = new LengthValidator(10, 11, phoneField) {
            @Override
            public void customValidation(Editable s) {
                String text = s.toString();
                if(text.length() < 2) return;
                if(!text.substring(0,2).equals("08")) {
                    phoneField.setError("Телефонният номер трябва да започва с 08");
                }
            }
        };
        phoneField.addTextChangedListener(phoneValidator);

        LengthValidator addyValidator = new LengthValidator(5, 255, addyField);
        addyField.addTextChangedListener(addyValidator);

        LengthValidator cityValidator = new LengthValidator(5, 150, cityField);
        cityField.addTextChangedListener(cityValidator);

        LengthValidator nameValidator = new LengthValidator(2, 100, nameField);
        nameField.addTextChangedListener(nameValidator);


        Button buttonNext = findViewById(R.id.button3);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneField.getText().toString();
                String address = addyField.getText().toString();
                String city = cityField.getText().toString();
                String name = nameField.getText().toString();


                Person person = new Person();
                person.setAge(0); //няма поле в условието
                person.setEmail(email);
                person.setName(name);
                person.setPhone(phone);
                person.setAddress(address);
                person.setCity(city);


                Intent newIntent = createIntent(Activity2.this);
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