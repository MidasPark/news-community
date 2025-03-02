import { fetchNYT, normalizeArticle } from '.'

export default defineEventHandler(async (event) => {
  const query = getQuery(event)
  const year = query.year || new Date().getFullYear()
  const month = query.month || new Date().getMonth() + 1
  
  try {
    const response = await fetchNYT(`/archive/v1/${year}/${month}.json`, {})
    
    if (!response?.response?.docs) {
      return { articles: [] }
    }
    
    const articles = response.response.docs.map(normalizeArticle)
    
    return {
      articles
    }
  } catch (error) {
    console.error('NYT Archive API 오류:', error)
    throw createError({
      statusCode: 500,
      message: 'NYT Archive API 오류가 발생했습니다.'
    })
  }
}) 