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
import org.springframework.core.env.Environment;

@Component
public class NytApiPort {
    private final RestTemplate restTemplate;
    private final String allApiUrl = "https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=s9GdCCaP8A6fmM6ic0bBaxbEQ20vfRHV";
    private final List<NewsArticleNyt> newsArticles;

    private final Environment environment;

    @Value("${my.config.api-key}")
    private String test1;

    @Value("${my.config.url}")
    private String test2;

    @Value("${tt1}")
    private String tt1;

    @Value("${tt2}")
    private String tt2;

    @Value("${tt3}")
    private String tt3;

    @Value("${tt4}")
    private String tt4;

    public NytApiPort(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
        this.newsArticles = fetchAllNewsArticles();
    }


    public List<NewsArticleNyt> fetchAllNewsArticles() {
        Properties dd = System.getProperties();
        Map<String, String> ddd = System.getenv();

        System.out.println("test1 =>  " + this.test1);
        System.out.println("test2 =>  " + this.test2);
        System.out.println("tt1 =>  " + this.tt1);
        System.out.println("tt2 =>  " + this.tt2);
        System.out.println("tt3 =>  " + this.tt3);
        System.out.println("tt4 =>  " + this.tt4);

        System.out.println("System.getProperty(\"tt1\") => " + System.getProperty("tt1"));
        System.out.println("System.getProperty(\"tt2\") => " + System.getProperty("tt2"));
        System.out.println("System.getProperty(\"tt1\") => " + System.getProperty("tt1"));
        System.out.println("System.getProperty(\"tt2\") => " + System.getProperty("tt2"));
        System.out.println("System.getProperty(\"tt3\") => " + System.getProperty("tt3"));
        System.out.println("System.getProperty(\"tt4\") => " + System.getenv("tt4"));


        System.out.println("environment.getProperty(\"my.config.api-key\") => " + environment.getProperty("my.config.api-key"));
        System.out.println("environment.getProperty(\"my.config.url\") => " + environment.getProperty("my.config.url"));
        System.out.println("environment.getProperty(\"tt3\") => " + environment.getProperty("tt1"));
        System.out.println("environment.getProperty(\"tt4\") => " + environment.getProperty("tt2"));
        System.out.println("environment.getProperty(\"tt4\") => " + environment.getProperty("tt3"));
        System.out.println("environment.getProperty(\"tt4\") => " + environment.getProperty("tt4"));


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
