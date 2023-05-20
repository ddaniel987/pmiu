package com.example.zad9;

public class News {
    private String title;
    private String author;
    private String source;

    public News(String title, String author, String source) {
        this.title = title;
        this.author = author;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
