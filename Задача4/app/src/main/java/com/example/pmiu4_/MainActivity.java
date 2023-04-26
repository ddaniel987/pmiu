package com.example.pmiu4_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmiu4_.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";

    @Override
    public Intent createIntent(Context context) {
        return new Intent(context, Activity2.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        EditText emailField = findViewById(R.id.editTextTextPersonName);
        Button nextBtn = findViewById(R.id.button);
        LengthValidator validator = new LengthValidator(5, 99, emailField) {
            @Override
            public void customValidation(Editable s) {
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
                Pattern pattern = Pattern.compile(emailRegex);
                boolean match = pattern.matcher(s.toString()).matches();
                if(!match) {
                    emailField.setError("Моля въведи валиден E-mail адрес.");
                    nextBtn.setEnabled(false);
                } else {
                    nextBtn.setEnabled(true);
                }

            }
        };

        emailField.addTextChangedListener(validator);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailField.getText().toString();

                Intent intent = createIntent(MainActivity.this);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}