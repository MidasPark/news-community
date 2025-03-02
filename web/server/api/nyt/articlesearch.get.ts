import { fetchNYT, normalizeArticle } from '.'

export default defineEventHandler(async (event) => {
  const query = getQuery(event)
  
  try {
    const response = await fetchNYT('/search/v2/articlesearch.json', {
      q: query.q || '',
      fq: query.fq || '',
      sort: query.sort || 'newest',
      page: query.page || 0
    })
    
    if (!response?.response?.docs) {
      return { articles: [] }
    }
    
    const articles = response.response.docs.map(normalizeArticle)
    
    return {
      articles
    }
  } catch (error) {
    console.error('NYT Article Search API 오류:', error)
    throw createError({
      statusCode: 500,
      message: 'NYT Article Search API 오류가 발생했습니다.'
    })
  }
}) 