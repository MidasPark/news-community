package com.salt.news.domain;

public record MultimediaArticleNyt(
        String url,
        String format,
        int height,
        int width,
        String type,
        String subtype,
        String caption,
        String copyright
) {}
