package com.salt.news.adapter.primary.out.rest;

import com.salt.news.port.primary.out.rest.NytApiPort;
import com.salt.news.domain.NewsArticleNyt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/rest/nyt")
public class NytController {

    private final NytApiPort nytApiPort;

    @Autowired
    public NytController(NytApiPort nytApiPort) {
        this.nytApiPort = nytApiPort;
    }

    @GetMapping("/update_news")
    public String updateNews() {
        List<NewsArticleNyt> response = nytApiPort.fetchAllNewsArticles();

        return "updateNews running!";
    }
}
 