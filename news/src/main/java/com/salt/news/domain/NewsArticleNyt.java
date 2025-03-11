package com.salt.news.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

public record NewsArticleNyt(
        @JsonProperty("slug_name") String slugName,
        String section,
        String subsection,
        String title,
        @JsonProperty("abstract") String abstractText,
        String uri,
        String url,
        String byline,
        @JsonProperty("item_type") String itemType,
        @JsonProperty("created_date") OffsetDateTime createdDate,
        @JsonProperty("published_date") OffsetDateTime publishedDate,
        @JsonProperty("material_type_facet") String materialTypeFacet,
        @JsonProperty("des_facet") List<String> desFacet,
        @JsonProperty("org_facet") List<String> orgFacet,
        @JsonProperty("per_facet") List<String> perFacet,
        @JsonProperty("geo_facet") List<String> geoFacet,
        List<MultimediaArticleNyt> multimedia
) {}

