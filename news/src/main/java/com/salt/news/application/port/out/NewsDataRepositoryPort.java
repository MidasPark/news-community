package com.salt.news.application.port.out;

import com.salt.news.domain.newsdata.entity.NewsDataArticleEntity;
import java.util.List;

public interface NewsDataRepositoryPort {
    NewsDataArticleEntity save(NewsDataArticleEntity entity);
    List<NewsDataArticleEntity> saveAll(List<NewsDataArticleEntity> entities);
}
