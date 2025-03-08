package com.salt.news.adapter.primary.out.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salt.news.port.primary.restapi.NytPort;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/grpc/nyt")
public class NytController {

    private final NytPort nytPort;

    @Autowired
    public NytController(NytPort nytPort) {
        this.nytPort = nytPort;
    }

    @GetMapping("/fetch_news_data")
    public String healthCheck() {
        nytPort.fetchNewsArticles();
        return "News Service is up and running!";
    }

    @GetMapping("/fetch_news_data2")
    public String healthCheck2() {
        return "News Service is up and running!";
    }
} 