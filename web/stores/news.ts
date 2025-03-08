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
  published_date: string
  multimedia?: Array<{
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
          published_date: '2023-10-01',
          multimedia: [{ url: 'https://placehold.co/600x400', format: 'Standard Thumbnail' }],
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
        {
          id: '2',
          title: '경제 뉴스 2',
          abstract: '경제 뉴스 2의 요약입니다.',
          url: 'https://example.com/news2',
          published_date: '2023-10-01',
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
        {
          id: '3',
          title: '경제 뉴스 3',
          abstract: '경제 뉴스 3의 요약입니다.',
          url: 'https://example.com/news3',
          published_date: '2023-10-01',
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
        {
          id: '4',
          title: '경제 뉴스 4',
          abstract: '경제 뉴스 4의 요약입니다.',
          url: 'https://example.com/news4',
          published_date: '2023-10-01',
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
        {
          id: '5',
          title: '경제 뉴스 5',
          abstract: '경제 뉴스 5의 요약입니다.',
          url: 'https://example.com/news5',
          published_date: '2023-10-01',
          relatedStocks: [
            { name: '테슬라', ticker: 'TSLA', trend: 'up' },
            { name: '애플', ticker: 'AAPL', trend: 'down' }
          ]
        },
      ]
    }
  }
}) 