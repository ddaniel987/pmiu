package com.example.zad9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleActivity extends Activity {
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView sourceTextView;
    private TextView textTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        titleTextView = findViewById(R.id.titleTextView);
        authorTextView = findViewById(R.id.authorTextView);
        sourceTextView = findViewById(R.id.sourceTextView);
        textTextView = findViewById(R.id.textTextView);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String author = intent.getStringExtra("author");
            String source = intent.getStringExtra("source");
            String text = intent.getStringExtra("text");

            titleTextView.setText(title);
            authorTextView.setText(author);
            sourceTextView.setText(source);
            textTextView.setText(text);
        }
    }
}
