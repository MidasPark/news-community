import { fetchNYT } from '.'

// 환경 변수로 API 키 설정하거나 여기서 직접 입력
const API_KEY = process.env.NYT_API_KEY || 'your-api-key-here'
const BASE_URL = 'https://api.nytimes.com/svc/topstories/v2'

export default defineEventHandler(async (event) => {
  const { section = 'business' } = getQuery(event)
  
  try {
    const response = await fetchNYT(`/topstories/v2/${section}.json`)
    
    if (!response?.results) {
      return { articles: [] }
    }
    
    // 뉴욕타임즈 API 응답을 애플리케이션에 맞게 변환
    const articles = response.results.map(article => ({
      id: article.url, 
      title: article.title,
      url: article.url,
      points: article.views || 0,
      user: article.byline?.replace('By ', '') || '',
      time: new Date(article.published_date || new Date()).getTime() / 1000,
      type: 'story',
      content: article.abstract || '',
      comments_count: 0,
      multimedia: article.multimedia || []
    }))
    
    return { articles }
  } catch (error) {
    console.error('뉴욕타임즈 API 요청 오류:', error)
    return { 
      articles: [],
      error: '뉴욕타임즈 뉴스를 가져오는 중 오류가 발생했습니다.'
    }
  }
}) 