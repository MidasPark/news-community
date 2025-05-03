package com.salt.news.adapter.out.persistence;

import com.salt.news.domain.newsdata.entity.NewsDataArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDataRepository extends JpaRepository<NewsDataArticleEntity, Long> {
}