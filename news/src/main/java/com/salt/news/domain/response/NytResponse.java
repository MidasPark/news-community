package com.salt.news.domain.response;

import java.util.List;
import com.salt.news.domain.NewsArticleNyt;

public class NytResponse {
    private List<NewsArticleNyt> articles;

    public List<NewsArticleNyt> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticleNyt> articles) {
        this.articles = articles;
    }
}