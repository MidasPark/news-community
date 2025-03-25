package com.salt.news.domain.news.response;

import java.util.List;

public record NewsDataResponse(
        String status,
        int totalResults,
        List<NewsDataArticle> results,
        String nextPage
) {}

