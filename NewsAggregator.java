package com.newsaggregator;

import java.io.*;
import java.util.*;

public class NewsAggregator {

    // List to store all news articles
    private List<NewsArticle> articles = new ArrayList<>();

    // Method to load news from the text file
    public void loadNewsFromFile(String filePath) throws IOException {
        articles.clear(); // Clear old data first

        File f = new File(filePath);
        if (!f.exists()) {
            System.err.println("⚠ news.txt not found at: " + f.getAbsolutePath());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                // Split into 4 parts: title, author, content, category
                String[] parts = line.split(",", 4);

                // If the line doesn’t have all 4 parts, skip it
                if (parts.length < 4) {
                    System.err.println("⚠ Skipping invalid line: " + line);
                    continue;
                }

                // Create an OnlineNews object
                NewsArticle article = new OnlineNews(
                        parts[0].trim(), // title
                        parts[1].trim(), // author
                        parts[2].trim(), // content
                        parts[3].trim()  // category
                );

                // Add article only if it's valid
                if (article != null) {
                    articles.add(article);
                }
            }
        }

        System.out.println("✅ Loaded " + articles.size() + " news articles successfully.");
    }

    // Method to show news in console (used in main)
    public void showNewsByCategory(String category) {
        boolean found = false;
        for (NewsArticle a : articles) {
            if (a != null && a.category != null && a.category.equalsIgnoreCase(category)) {
                a.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No news found for category: " + category);
        }
    }

    // Method to get news list for GUI (used in UserInputGUI)
    public List<NewsArticle> getArticlesByCategory(String category) {
        List<NewsArticle> filtered = new ArrayList<>();
        for (NewsArticle a : articles) {
            if (a != null && a.category != null && a.category.equalsIgnoreCase(category)) {
                filtered.add(a);
            }
        }
        return filtered;
    }
}