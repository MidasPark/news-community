package com.salt.news.domain.response;

import java.util.List;
import com.salt.news.domain.NewsArticleNyt;

public class NytResponse {
    private List<NewsArticleNyt> results; // 응답 데이터의 필드 이름과 일치

    public List<NewsArticleNyt> getResults() {
        return results;
    }

    public void setResults(List<NewsArticleNyt> results) {
        this.results = results;
    }
}