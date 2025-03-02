import { fetchNYT } from '.'

export default defineEventHandler(async (event) => {
  const { section = 'home' } = getQuery(event)
  
  const response = await fetchNYT(`/topstories/v2/${section}.json`)
  
  return {
    articles: response.results.map(mapArticle)
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
    updated_date: article.updated_date,
    section: article.section,
    subsection: article.subsection,
    multimedia: article.multimedia,
    // 애플리케이션 호환성을 위한 필드
    user: article.byline.replace('By ', ''),
    time: new Date(article.published_date).getTime() / 1000,
    points: 0,
    type: 'story',
    content: article.abstract,
    comments_count: 0
  }
} 