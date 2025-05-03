package com.salt.news.adapter.out;

import com.salt.news.domain.newsdata.valueobject.NewsDataResponse;
import com.salt.news.application.port.out.NewsDataPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/news_data")
@Tag(name = "News Data", description = "News Data")
public class NewsFetchController {

    private final NewsDataPort newsDataPort;

    @Autowired
    public NewsFetchController(NewsDataPort newsDataPort) {
        this.newsDataPort = newsDataPort;
    }

    @Operation(
            summary = "newsData fetch",
            description = "newsData API를 이용해서 뉴스 조회",
            tags = {"News Data"}
    )
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "ok")
    )
    @GetMapping("/fetch_list")
    public NewsDataResponse updateNews() {
        // 뉴스 데이터를 가져옴
        NewsDataResponse result = newsDataPort.fetchNewsArticles("business,politics", "economic,policy");

        // 조건 검사: size가 0이거나 status가 "200"이 아닌 경우 예외 발생
        if (result.results().isEmpty() || !"200".equals(result.status())) {
            throw new IllegalStateException("Invalid news data response: status=" + result.status() + ", results size=" + result.results().size());
        }

        return result;
    }
}
 