package com.salt.news.port.primary.out.rest;

import com.salt.news.domain.news.response.NewsDataResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NewsDataPort {
    private final String baseUrl = "https://newsdata.io/api/1/news";
    private final Environment env;
    private final RestTemplate restTemplate;

    public NewsDataPort(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void init() {
    }

    public NewsDataResponse fetchNewsArticles(String category, String query) {
        String apiUrl = getApiUrl(category, query);
        try {
            ResponseEntity<NewsDataResponse> response = restTemplate.getForEntity(apiUrl, NewsDataResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("NewsData API 요청 실패", e);
        }
    }

    private String getApiUrl(String category, String query) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("country", "us")
                .queryParam("language", "en")
                .queryParam("category", category)
                .queryParam("q", query)
                .queryParam("apikey", env.getProperty("NEWS_DATA_KEY"))
                .build()
                .toUriString();
    }
}
