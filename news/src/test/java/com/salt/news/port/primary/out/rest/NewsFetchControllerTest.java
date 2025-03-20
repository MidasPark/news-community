//package com.salt.news.port.primary.out.rest;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.junit.jupiter.api.Assertions;
//import java.util.List;
//import com.salt.news.domain.NewsArticleNyt;
//
//public class NewsFetchControllerTest {
//
//    private NewsDataPort newsDataPort;
//
//    @BeforeEach
//    public void setUp() {
//        newsDataPort = Mockito.mock(NewsDataPort.class);
//    }
//
//    @Test
//    @DisplayName("NYT API에서 뉴스 데이터를 성공적으로 가져오는지 테스트")
//    public void testFetchNewsFromNyt() {
//        // Given
//        List<NewsArticleNyt> mockArticles = List.of(
//                new NewsArticleNyt("Title1", "Section1", "Subsection1", "Abstract1", "URL1"),
//                new NewsArticleNyt("Title2", "Section2", "Subsection2", "Abstract2", "URL2")
//        );
//        Mockito.when(newsDataPort.fetchAllNewsArticles()).thenReturn(mockArticles);
//
//        // When
//        List<NewsArticleNyt> result = newsDataPort.fetchAllNewsArticles();
//
//        // Then
//        Assertions.assertFalse(result.isEmpty(), "The result should not be empty");
//        Assertions.assertEquals(2, result.size(), "The result should contain 2 articles");
//    }
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
//}
