import { $fetch } from 'ofetch'

// API 키 설정
const API_KEY = process.env.NYT_API_KEY || ''
const BASE_URL = 'https://api.nytimes.com/svc'

// 공통 fetch 함수
export async function fetchNYT(endpoint: string, params: Record<string, any> = {}) {
  try {
    return await $fetch(endpoint, {
      baseURL: BASE_URL,
      params: {
        'api-key': API_KEY,
        ...params
      },
      headers: {
        'Accept': 'application/json'
      }
    })
  } catch (error) {
    console.error(`NYT API 요청 오류 (${endpoint}):`, error)
    throw createError({
      statusCode: 500,
      message: '뉴욕타임즈 API 요청 중 오류가 발생했습니다.'
    })
  }
}

// 기사 데이터 정규화 함수 - API 응답을 일관된 형태로 변환
export function normalizeArticle(article: any) {
  return {
    id: article.uri || article._id || article.url || String(Date.now() + Math.random()),
    title: article.title || article.headline?.main || '제목 없음',
    abstract: article.abstract || article.snippet || article.lead_paragraph || '',
    url: article.url || article.web_url || '',
    published_date: article.published_date || article.pub_date || new Date().toISOString(),
    byline: article.byline?.original || article.byline || '',
    multimedia: article.multimedia || []
  }
} 