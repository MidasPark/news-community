package com.salt.news.port.primary.out.rest;

import com.salt.news.adapter.primary.out.rest.v1.NewsFetchController;
import com.salt.news.domain.news.response.NewsDataArticle;
import com.salt.news.domain.news.response.NewsDataResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mockito 확장 활성화
public class NewsFetchControllerTest {

    @Mock
    private NewsDataPort newsDataPort; // 모의 객체 생성

    @InjectMocks
    private NewsFetchController newsFetchController; // 의존성 자동 주입

    @Test
    @DisplayName("NewsData API에서 뉴스 데이터를 성공적으로 가져오는지 테스트")
    public void testFetchNewsFromNyt() {
        // Given: Mock 데이터 생성
        NewsDataArticle mockArticle = new NewsDataArticle(
                "12345",
                "Test Article",
                "https://example.com/article",
                List.of("test", "example"),
                List.of("John Doe"),
                null, // video_url (null 허용)
                "Sample description",
                "Sample content",
                "2023-10-01 12:00:00",
                "https://example.com/image.jpg",
                "source-123",
                1,
                "Test Source",
                "https://example.com",
                "https://example.com/favicon.ico",
                List.of("US"),
                List.of("Business")
        );

        NewsDataResponse mockResponse = new NewsDataResponse(
                "success",
                1,
                List.of(mockArticle),
                "https://api.example.com/next-page"
        );

        // Mock 객체 설정
        when(newsDataPort.fetchNewsArticles("business,politics", "economic,policy")).thenReturn(mockResponse);

        // When: 실제 메서드 호출
        NewsDataResponse result = newsDataPort.fetchNewsArticles("business,politics", "economic,policy");

        // Then: 검증
        assertEquals("success", result.status());
        assertEquals(1, result.totalResults());
        assertEquals(1, result.results().size());

        NewsDataArticle firstArticle = result.results().get(0);
        assertEquals("Test Article", firstArticle.title());
        assertEquals("https://example.com/article", firstArticle.link());
        assertEquals(List.of("test", "example"), firstArticle.keywords());

        // Mock 호출 검증
        verify(newsDataPort, times(1))
                .fetchNewsArticles("business,politics", "economic,policy");
    }
//
//    @Test
//    @DisplayName("가져온 뉴스 데이터를 데이터베이스에 성공적으로 저장하는지 테스트")
//    public void testSaveNewsToDatabase() {
//        // Given
//        NewsArticleNyt article = new NewsArticleNyt("Title", "Section", "Subsection", "Abstract", "URL");
//        Mockito.doNothing().when(nytApiPort).saveToDatabase(article);
//
//        // When & Then
//        Assertions.assertDoesNotThrow(() -> newsDataPort.saveToDatabase(article),
//                "Saving news to database should not throw an exception");
//    }
//
//    @Test
//    @DisplayName("저장된 뉴스 데이터를 성공적으로 조회하는지 테스트")
//    public void testRetrieveSavedNews() {
//        // Given
//        List<NewsArticleNyt> mockData = List.of(
//                new NewsArticleNyt("Title1", "Section1", "Subsection1", "Abstract1", "URL1"),
//                new NewsArticleNyt("Title2", "Section2", "Subsection2", "Abstract2", "URL2")
//        );
//        Mockito.when(newsDataPort.getSavedNews()).thenReturn(mockData);
//
//        // When
//        List<NewsArticleNyt> result = newsDataPort.getSavedNews();
//
//        // Then
//        Assertions.assertEquals(2, result.size(), "The size of the result should be 2");
//        Assertions.assertEquals("Title1", result.get(0).title(), "The first article's title should match");
//        Assertions.assertEquals("Title2", result.get(1).title(), "The second article's title should match");
//    }
}
