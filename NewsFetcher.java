package com.newsaggregator;
import java.net.*;
import java.io.*;

public class NewsFetcher {
    public static void fetchFromURL(String site) {
        try {
            URL url = new URL(site);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (Exception e) {
            System.out.println("Error fetching news: " + e.getMessage());
        }
    }
}


