package com.salt.news.port.primary.out.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import com.salt.news.domain.NewsArticleNyt;

/**
 * 뉴욕 타임즈 API와 관련된 기능을 테스트하는 클래스입니다.
 */
public class NytApiTest {

    private NytApiPort nytApiPort;

    /**
     * 각 테스트 실행 전에 필요한 설정을 수행합니다.
     * 여기서는 NytPort의 모의 객체를 생성합니다.
     */
    @BeforeEach
    public void setUp() {
        nytApiPort = Mockito.mock(NytApiPort.class);
    }

    /**
     * NYT에서 뉴스 데이터를 가져오는 기능을 테스트합니다.
     * <p>
     * 이 테스트는 NYT API로부터 뉴스를 가져오는 메서드의 동작을 검증합니다.
     * </p>
     */
    @Test
    public void testFetchNewsFromNyt() {
        List<NewsArticleNyt> res = nytApiPort.fetchAllNewsArticles();
        res.forEach(article -> {
            System.out.println("Title: " + article.title());
            System.out.println("Section: " + article.section());
            System.out.println("Subsection: " + article.subsection());
            System.out.println("Abstract: " + article.abstractText());
            System.out.println("URL: " + article.url());
        });

        // 1. NYT에서 뉴스 데이터를 가져오는 기능을 테스트합니다.
        // Arrange: 필요한 준비 작업을 수행합니다.

        // Act: NYT에서 뉴스를 가져오는 메서드를 호출합니다.

        // Assert: 가져온 뉴스 데이터가 예상대로인지 검증합니다.
    }

    /**
     * 가져온 뉴스 데이터를 데이터베이스에 저장하는 기능을 테스트합니다.
     * <p>
     * 이 테스트는 뉴스 데이터를 데이터베이스에 저장하는 메서드의 동작을 검증합니다.
     * </p>
     */
    @Test
    public void testSaveNewsToDatabase() {
        System.out.println("testSaveNewsToDatabase!");
        // 2. 가져온 뉴스 데이터를 데이터베이스에 저장하는 기능을 테스트합니다.
        // Arrange: 필요한 준비 작업을 수행합니다.

        // Act: 뉴스 데이터를 데이터베이스에 저장하는 메서드를 호출합니다.

        // Assert: 데이터베이스에 데이터가 올바르게 저장되었는지 검증합니다.
    }

    /**
     * 저장된 뉴스 데이터를 호출하는 기능을 테스트합니다.
     * <p>
     * 이 테스트는 데이터베이스에 저장된 뉴스를 호출하는 메서드의 동작을 검증합니다.
     * </p>
     */
    @Test
    public void testRetrieveSavedNews() {
        System.out.println("testRetrieveSavedNews!");
        // 3. 저장된 뉴스 데이터를 호출하는 기능을 테스트합니다.
        // Arrange: 필요한 준비 작업을 수행합니다.

        // Act: 저장된 뉴스 데이터를 호출하는 메서드를 호출합니다.

        // Assert: 호출된 뉴스 데이터가 예상대로인지 검증합니다.
    }
}