package com.salt.news.adapter.in;

import com.salt.news.application.service.newsdata.NewsDataService;
import com.salt.news.domain.newsdata.valueobject.NewsDataArticle;
import com.salt.news.domain.newsdata.valueobject.NewsDataResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news-data")
@Tag(name = "News API", description = "뉴스 관련 API")
public class NewsDataController {
    private final NewsDataService newsDataService;

    public NewsDataController(NewsDataService newsDataService) {
        this.newsDataService = newsDataService;
    }

    @PostMapping("/fetch-and-store")
    public Boolean fetchAndStoreNewsData() {
        newsDataService.fetchNewsData();
        NewsDataResponse data1 = newsDataService.getNewsData();
        List<NewsDataArticle> data = newsDataService.getNewsDataArticle();

        return true;
    }
}
