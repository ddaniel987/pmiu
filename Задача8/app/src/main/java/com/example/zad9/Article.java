package com.example.zad9;

public class Article {
    private String title;
    private String author;
    private String source;
    private String text;

    public Article(String title, String author, String source, String text) {
        this.title = title;
        this.author = author;
        this.source = source;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
