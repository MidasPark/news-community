package com.salt.news.domain;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class NewsArticleNyt {
    private String slugName;
    private String section;
    private String subsection;
    private String title;
    private String abstractText;
    private String uri;
    private String url;
    private String byline;
    private String itemType;
    private String source;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;
    private LocalDateTime firstPublishedDate;
    private String materialTypeFacet;
    private String kicker;
    private String subheadline;
    private List<String> desFacet;
    private List<String> orgFacet;
    private List<String> perFacet;
    private List<String> geoFacet;
    private List<Multimedia> multimedia;

    // Getters and Setters

    public static class Multimedia {
        private String url;
        private String format;
        private int height;
        private int width;
        private String type;
        private String subtype;
        private String caption;
        private String copyright;

        // Getters and Setters
    }
}

