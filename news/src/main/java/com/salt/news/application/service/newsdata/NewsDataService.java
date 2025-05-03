package com.salt.news.application.service.newsdata;

import com.salt.news.application.port.in.newsdata.GetNewsDataUseCase;
import com.salt.news.application.port.in.newsdata.SetNewsDataUseCase;
import com.salt.news.domain.newsdata.valueobject.NewsDataArticle;
import com.salt.news.domain.newsdata.valueobject.NewsDataResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.salt.news.application.port.out.NewsDataPort;

@Service
public class NewsDataService implements GetNewsDataUseCase, SetNewsDataUseCase {
    private final NewsDataPort newsDataPort;
    private NewsDataResponse newsData;
    private List<NewsDataArticle> newsDataArticle;

    public NewsDataService(NewsDataPort newsDataPort) {
        this.newsData = new NewsDataResponse();
        this.newsDataArticle = new ArrayList<>();
        this.newsDataPort = newsDataPort;
    }

    @Override
    public NewsDataResponse getNewsData() {
        return this.newsData;
    }

    @Override
    public List<NewsDataArticle> getNewsDataArticle() {
        return this.newsDataArticle;
    }

    @Override
    public void setNewsData(NewsDataResponse data) {
        this.newsData = data;
    }

    @Override
    public void setNewsDataArticle(List<NewsDataArticle> data) {
        this.newsDataArticle = data;
    }

    /**
     * NewsDataResponse 데이터를 받아서
     * 내부 뉴스 데이터와 기사 리스트를 설정한다.
     *
     * @param data 뉴스 데이터 응답 객체
     */
    public void setNewsDatas (NewsDataResponse data) {
        setNewsData(data);
        setNewsDataArticle(data.results());
    }

    /**
     * NewsData API 를 통해서 데이터를 받는다
     */
    public void fetchNewsData() {
        NewsDataResponse newsDataResponse = this.newsDataPort.fetchNewsArticles("business,politics", "economic,policy");
        setNewsDatas(newsDataResponse);
        saveToDb();
    }

    /**
     * 뉴스 정보를 DB에 저장한다
     */
    public void saveToDb() {
        List<NewsDataArticle> list = getNewsDataArticle();
    }
}
