package com.salt.news.domain.newsdata.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news_data_articles")
public class NewsDataArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_id", unique = true, nullable = false)
    private String articleId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "source_priority")
    private Integer sourcePriority;

    @Column(name = "source_url")
    private String sourceUrl;

    @Type(ListArrayType.class)
    @Column(name = "country", columnDefinition = "text[]")
    private List<String> country;

    @Type(ListArrayType.class)
    @Column(name = "category", columnDefinition = "text[]")
    private List<String> category;

    @Type(ListArrayType.class)
    @Column(name = "keywords", columnDefinition = "text[]")
    private List<String> keywords;

    @Column(name = "pub_date")
    private LocalDateTime pubDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSourcePriority() {
        return sourcePriority;
    }

    public void setSourcePriority(Integer sourcePriority) {
        this.sourcePriority = sourcePriority;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
