package com.salt.news.port.primary.out.rest;

import com.salt.news.domain.NewsArticleNyt;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.salt.news.domain.response.NytResponse;
import java.util.List;

@Component
public class NytApiPort {
    private final Environment env;
    private final RestTemplate restTemplate;
    private final List<NewsArticleNyt> newsArticles;

    public NytApiPort(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
        this.newsArticles = fetchAllNewsArticles();
    }

    public List<NewsArticleNyt> fetchAllNewsArticles() {
        String apiUrl = String.format("%s/content/all/all.json?api-key=%s",
                this.env.getProperty("nyt_api_v3_url"),
                this.env.getProperty("nyt_api_v3_key"));

        ResponseEntity<NytResponse> response = restTemplate.getForEntity(apiUrl, NytResponse.class);

        try {
            NytResponse nytResponse = response.getBody();
            return (nytResponse != null) ? nytResponse.getResults() : List.of();
        } catch (RestClientException e) {
            // 예외 처리 코드
            throw new RuntimeException("NYT API 요청 실패", e);
        }
    }

    public List<NewsArticleNyt> getNewsArticles() {
        return newsArticles;
    }
}