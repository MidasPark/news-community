package com.salt.news.domain.newsdata.valueobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
public record NewsDataArticle(
    @JsonProperty("article_id") String articleId,
    String title,
    String link,
    List<String> keywords,
    List<String> creator,
    @JsonProperty("video_url") String videoUrl,
    String description,
    String content,
    String pubDate,
    @JsonProperty("image_url") String imageUrl,
    @JsonProperty("source_id") String sourceId,
    @JsonProperty("source_priority") int sourcePriority,
    @JsonProperty("source_name") String sourceName,
    @JsonProperty("source_url") String sourceUrl,
    @JsonProperty("source_icon") String sourceIcon,
    List<String> country,
    List<String> category
) {
    // 파라미터 없는 생성자: 기본값으로 채움
    public NewsDataArticle() {
        this(
                "", "", "", List.of(), List.of(), "", "", "", "",
                "", "", 0, "", "", "", List.of(), List.of()
        );
    }
}