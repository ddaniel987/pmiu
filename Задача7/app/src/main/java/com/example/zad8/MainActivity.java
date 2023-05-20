package com.example.zad8;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText emailEditText;
    private ProgressBar progressBar;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        progressBar = findViewById(R.id.progressBar);
        validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });
    }

    private void validateEmail() {
        progressBar.setVisibility(View.VISIBLE);
        validateButton.setEnabled(false);

        final String email = emailEditText.getText().toString();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isValid = isValidEmail(email);

                progressBar.setVisibility(View.GONE);
                validateButton.setEnabled(true);

                if (isValid) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Невалиден имейл", Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000);
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
