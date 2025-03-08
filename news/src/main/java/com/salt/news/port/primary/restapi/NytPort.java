package com.salt.news.port.primary.restapi;

import com.salt.news.domain.NewsArticleNyt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.salt.news.domain.response.NytResponse;

import java.util.List;

@Component
public class NytPort {
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=s9GdCCaP8A6fmM6ic0bBaxbEQ20vfRHV";
    private List<NewsArticleNyt> newsArticles;

    public NytPort(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.newsArticles = fetchNewsArticles();
    }

    public List<NewsArticleNyt> fetchNewsArticles() {
        ResponseEntity<NytResponse> response = restTemplate.getForEntity(apiUrl, NytResponse.class);
        NytResponse nytResponse = response.getBody();
        return (nytResponse != null) ? nytResponse.getArticles() : List.of();
    }

    public List<NewsArticleNyt> getNewsArticles() {
        return newsArticles;
    }
}