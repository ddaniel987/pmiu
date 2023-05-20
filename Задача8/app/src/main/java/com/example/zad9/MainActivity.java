package com.example.zad9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView newsListView;
    private List<News> newsList;
    private ArrayAdapter<News> newsAdapter;
    private int newsCount = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsListView = findViewById(R.id.newsListView);
        newsList = new ArrayList<>();


        createSampleNews();


        newsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, newsList);
        newsListView.setAdapter(newsAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News clickedNews = newsList.get(position);
                openArticleActivity(clickedNews);
            }
        });


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                addNewNews();
                newsAdapter.notifyDataSetChanged();
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }

    private void createSampleNews() {
        for (int i = 0; i < newsCount; i++) {
            String title = "News Title " + (i + 1);
            String author = "Author " + (i + 1);
            String source = "Source " + (i + 1);
            News news = new News(title, author, source);
            newsList.add(news);
        }
    }

    private void addNewNews() {
        newsCount++;
        String title = "News Title " + newsCount;
        String author = "Author " + newsCount;
        String source = "Source " + newsCount;
        News news = new News(title, author, source);
        newsList.add(news);
    }

    private void openArticleActivity(News news) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("title", news.getTitle());
        intent.putExtra("author", news.getAuthor());
        intent.putExtra("source", news.getSource());
        startActivity(intent);
    }
}
