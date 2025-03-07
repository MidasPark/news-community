import { defineStore } from 'pinia'

// 주식 정보 타입
interface Stock {
  name: string
  ticker: string
  trend: 'up' | 'down'
}

// 기사 타입
interface Article {
  id: string
  title: string
  abstract: string
  url: string
  byline: string
  published_date: string
  multimedia: Array<{
    url: string
    format: string
  }>
  relatedStocks: Stock[]
}

export const useNewsStore = defineStore('news', {
  state: () => ({
    articles: [] as Article[]
  }),
  actions: {
    fetchArticles() {
      // API 호출을 통해 뉴스 기사 데이터를 가져오는 로직을 여기에 추가하세요.
      this.articles = [
        {
          id: '1',
          title: '경제 뉴스 1',
          abstract: '경제 뉴스 1의 요약입니다.',
          url: 'https://example.com/news1',
          byline: '기자 이름',
          published_date: '2023-10-01',
          multimedia: [{ url: 'https://example.com/image1.jpg', format: 'Standard Thumbnail' }],
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
        // 추가 기사 데이터...
      ]
    }
  }
}) 