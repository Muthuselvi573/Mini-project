package com.newsaggregator;

public abstract class NewsArticle {
    protected String title;
    protected String author;
    protected String content;
    protected String category;

    public NewsArticle(String title, String author, String content, String category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    // Abstract method to be implemented in child class
    public abstract void display();
}