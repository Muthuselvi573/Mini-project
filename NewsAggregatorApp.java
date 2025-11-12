package com.newsaggregator;

import java.util.Scanner;

public class NewsAggregatorApp {
    public static void main(String[] args) {
        try {
            // Step 1: Create database table
            DatabaseManager.createTable();

            // Step 2: Get input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String name = sc.nextLine();

            System.out.print("Enter your password: ");
            String pass = sc.nextLine();

            System.out.print("Enter your preferred categories (comma separated, e.g. Technology,Sports): ");
            String prefInput = sc.nextLine();
            String[] preferences = prefInput.split(",");

            User user = new User(name, pass, preferences);

            // Step 3: Load and show news
            NewsAggregator aggregator = new NewsAggregator();
            aggregator.loadNewsFromFile("news.txt");

            System.out.println("\nNews for " + user.getUsername() + ":\n");
            for (String cat : user.getPreferences()) {
                aggregator.showNewsByCategory(cat.trim());
            }

            // Step 4: Start background threads (optional)
            Thread t1 = new FetchThread("https://example.com/tech");
            Thread t2 = new FetchThread("https://example.com/sports");
            t1.start();
            t2.start();

            // Step 5: Launch GUI
            NewsGUI.main(null);

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}