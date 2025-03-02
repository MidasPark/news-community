import { fetchNYT, normalizeArticle } from '.'

export default defineEventHandler(async (event) => {
  const query = getQuery(event)
  const section = query.section || 'all-sections'
  const period = query.period || '7' // 1, 7, 30 days
  
  try {
    // section을 쿼리 파라미터가 아닌 URL 경로에 포함시킴
    const response = await fetchNYT(`/mostpopular/v2/viewed/${section}/${period}.json`)
    
    if (!response?.results) {
      return { articles: [] }
    }
    
    // 필요한 경우 제한
    let articles = response.results
    if (query.limit && !isNaN(Number(query.limit))) {
      articles = articles.slice(0, Number(query.limit))
    }
    
    return {
      articles: articles.map(normalizeArticle)
    }
  } catch (error) {
    console.error('NYT Most Popular API 오류:', error)
    
    // 오류 발생 시 빈 배열 반환하여 프론트엔드에서 오류 처리 가능하게 함
    return { 
      articles: [],
      error: '뉴욕 타임즈 API 요청 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.'
    }
  }
})

// 공통 데이터 매핑 함수
function mapArticle(article: any) {
  return {
    id: article.url,
    title: article.title,
    url: article.url,
    abstract: article.abstract,
    byline: article.byline,
    published_date: article.published_date,
    section: article.section,
    media: article.media,
    // 애플리케이션 호환성을 위한 필드
    user: article.byline.replace('By ', ''),
    time: new Date(article.published_date).getTime() / 1000,
    points: article.views || 0,
    type: 'story',
    content: article.abstract,
    comments_count: 0
  }
} 