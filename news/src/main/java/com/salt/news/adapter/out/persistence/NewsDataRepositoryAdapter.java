package com.salt.news.adapter.out.persistence;

import com.salt.news.domain.newsdata.entity.NewsDataArticleEntity;
import com.salt.news.application.port.out.NewsDataRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsDataRepositoryAdapter implements NewsDataRepositoryPort {

    private final NewsDataRepository newsDataRepository;

    public NewsDataRepositoryAdapter(NewsDataRepository newsDataRepository) {
        this.newsDataRepository = newsDataRepository;
    }

    @Override
    public NewsDataArticleEntity save(NewsDataArticleEntity entity) {
        return newsDataRepository.save(entity);
    }

    @Override
    public List<NewsDataArticleEntity> saveAll(List<NewsDataArticleEntity> entities) {
        return newsDataRepository.saveAll(entities);
    }
}