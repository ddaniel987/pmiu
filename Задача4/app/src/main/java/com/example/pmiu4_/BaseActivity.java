package com.example.pmiu4_;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract Intent createIntent(Context context);
}