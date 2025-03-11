package com.salt.news.port.primary.out.rest;

import com.salt.news.domain.NewsArticleNyt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.salt.news.domain.response.NytResponse;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class NytApiPort {
    private final RestTemplate restTemplate;
    private final String allApiUrl = "https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=s9GdCCaP8A6fmM6ic0bBaxbEQ20vfRHV";
    private final List<NewsArticleNyt> newsArticles;

    @Value("${my.config.api-key}")
    private String test1;

    @Value("${my.config.url}")
    private String test2;

    public NytApiPort(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.newsArticles = fetchAllNewsArticles();
    }

    public List<NewsArticleNyt> fetchAllNewsArticles() {
        String apiKey = System.getProperty("ukrl");
        String spring = System.getProperty("kname");
        String kest = System.getProperty("ktest");
        String kest1 = System.getenv("kname");

        // size 67
        Properties dd = System.getProperties();
        // size 35
        Map<String, String> ddd = System.getenv();

        System.out.print(this.test1);
        System.out.print(this.test2);

        ResponseEntity<NytResponse> response = restTemplate.getForEntity(allApiUrl, NytResponse.class);
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