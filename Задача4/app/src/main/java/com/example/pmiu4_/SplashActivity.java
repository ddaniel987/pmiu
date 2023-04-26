package com.example.pmiu4_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends BaseActivity implements View.OnClickListener {
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.intent = createIntent(this);
        ((Button)findViewById(R.id.button5)).setOnClickListener(this);
    }

    @Override
    public Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }


    @Override
    public void onClick(View view) {
        if(this.intent == null) {
            Log.d("SplashActivity", "Intent is null");
            return;
        }

        startActivity(this.intent);
    }
}