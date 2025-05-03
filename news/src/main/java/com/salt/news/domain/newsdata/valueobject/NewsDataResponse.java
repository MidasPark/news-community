package com.salt.news.domain.newsdata.valueobject;

import java.util.List;

public record NewsDataResponse(
        String status,
        int totalResults,
        List<NewsDataArticle> results,
        String nextPage
) {
    // 기본 생성자: 모든 필드에 기본값 할당
    public NewsDataResponse() {
        this(
                "fail",               // status 기본값
                0,                // totalResults 기본값
                List.of(),        // results 기본값: 빈 리스트
                ""                // nextPage 기본값
        );
    }
}

