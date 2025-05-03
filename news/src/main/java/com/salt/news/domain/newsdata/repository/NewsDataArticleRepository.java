package com.salt.news.domain.newsdata.repository;

import com.salt.news.domain.newsdata.entity.NewsDataArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsDataArticleRepository extends JpaRepository<NewsDataArticleEntity, Long> {
    Optional<NewsDataArticleEntity> findByArticleId(String articleId);
}
