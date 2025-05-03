package com.salt.news.application.port.in.newsdata;

import com.salt.news.domain.newsdata.valueobject.NewsDataArticle;
import com.salt.news.domain.newsdata.valueobject.NewsDataResponse;

import java.util.List;

public interface SetNewsDataUseCase {
    void setNewsData(NewsDataResponse data);
    void setNewsDataArticle(List<NewsDataArticle> data);
}