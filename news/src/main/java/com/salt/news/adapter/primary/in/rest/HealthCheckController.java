package com.salt.news.adapter.primary.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "News API", description = "뉴스 관련 API")
public class HealthCheckController {

    @Operation(summary = "헬스 체크", description = "")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "ok")
    )
    @GetMapping("/health_check")
    public String healthCheck() {
        return "News Service is up and running!";
    }
}
