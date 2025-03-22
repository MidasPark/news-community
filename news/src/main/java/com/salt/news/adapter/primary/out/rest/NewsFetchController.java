package com.salt.news.adapter.primary.out.rest;

import com.salt.news.domain.news.response.NewsDataResponse;
import com.salt.news.port.primary.out.rest.NewsDataPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/news/fetch")
public class NewsFetchController {

    private final NewsDataPort newsDataPort;

    @Autowired
    public NewsFetchController(NewsDataPort newsDataPort) {
        this.newsDataPort = newsDataPort;
    }

    @GetMapping("/update_news")
    public String updateNews() {
        NewsDataResponse response = newsDataPort.fetchNewsArticles("business,politics", "economic,policy");

        return "updateNews running!";
    }
}
 