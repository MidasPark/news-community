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
    // 목업 데이터
    mockArticles: [
      {
        id: '1',
        title: '인플레이션 둔화에 따른 경제 회복 신호',
        abstract: '최근 발표된 경제 지표에 따르면 인플레이션이 예상보다 빠르게 둔화되고 있어 경제 회복에 긍정적인 신호로 분석됩니다.',
        url: 'https://example.com/economic-recovery',
        byline: '김경제 기자',
        published_date: '2023-08-15T09:00:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?economy',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '삼성전자', ticker: '005930.KS', trend: 'up' },
          { name: 'LG전자', ticker: '066570.KS', trend: 'up' }
        ]
      },
      {
        id: '2',
        title: '중앙은행, 금리 동결 결정...시장 안정화 기대',
        abstract: '중앙은행이 기준금리를 현 수준에서 동결하기로 결정했습니다. 이는 경기 침체 우려와 인플레이션 사이에서 균형을 맞추려는 시도로 해석됩니다.',
        url: 'https://example.com/interest-rate-freeze',
        byline: '이금융 기자',
        published_date: '2023-08-14T14:30:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?bank',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: 'KB금융', ticker: '105560.KS', trend: 'up' },
          { name: '신한지주', ticker: '055550.KS', trend: 'down' }
        ]
      },
      {
        id: '3',
        title: '테크 기업들, AI 투자 확대...클라우드 시장 경쟁 심화',
        abstract: '주요 테크 기업들이 인공지능 기술 개발에 대규모 투자를 발표했습니다. 이로 인해 클라우드 컴퓨팅 시장의 경쟁이 더욱 치열해질 전망입니다.',
        url: 'https://example.com/tech-ai-investment',
        byline: '박테크 기자',
        published_date: '2023-08-13T11:15:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?technology',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '네이버', ticker: '035420.KS', trend: 'up' },
          { name: '카카오', ticker: '035720.KS', trend: 'up' }
        ]
      },
      {
        id: '4',
        title: '글로벌 공급망 이슈 완화...물류 비용 하락세',
        abstract: '코로나19 이후 지속되었던 글로벌 공급망 병목 현상이 점차 완화되고 있습니다. 컨테이너 운송 비용이 하락하며 수출 기업들에 호재로 작용할 전망입니다.',
        url: 'https://example.com/supply-chain-improvement',
        byline: '최물류 기자',
        published_date: '2023-08-12T16:45:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?shipping',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: 'HMM', ticker: '011200.KS', trend: 'down' },
          { name: '현대글로비스', ticker: '086280.KS', trend: 'up' }
        ]
      },
      {
        id: '5',
        title: '원자재 가격 상승세...인프라 투자 확대 영향',
        abstract: '주요국의 인프라 투자 확대로 철강, 구리 등 원자재 가격이 상승세를 보이고 있습니다. 건설 및 중공업 섹터에 긍정적 영향이 예상됩니다.',
        url: 'https://example.com/commodity-prices-rise',
        byline: '정원자재 기자',
        published_date: '2023-08-11T10:20:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?construction',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '포스코', ticker: '005490.KS', trend: 'up' },
          { name: '현대건설', ticker: '000720.KS', trend: 'up' }
        ]
      },
      {
        id: '6',
        title: '소비자 신뢰지수 개선...소매 판매 증가 기대',
        abstract: '최근 발표된 소비자 신뢰지수가 예상보다 크게 개선되었습니다. 이는 향후 소매 판매 증가로 이어질 가능성이 높아 소비재 기업들에 긍정적입니다.',
        url: 'https://example.com/consumer-confidence',
        byline: '김소비 기자',
        published_date: '2023-08-10T13:25:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?shopping',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '이마트', ticker: '139480.KS', trend: 'up' },
          { name: 'CJ제일제당', ticker: '097950.KS', trend: 'up' }
        ]
      },
      {
        id: '7',
        title: '바이오 산업 투자 활발...신약 개발 경쟁 가속화',
        abstract: '글로벌 제약사들과 벤처캐피털의 바이오 산업 투자가 활발해지고 있습니다. 특히 AI를 활용한 신약 개발 분야에 자금이 집중되는 추세입니다.',
        url: 'https://example.com/biotech-investment',
        byline: '박바이오 기자',
        published_date: '2023-08-09T09:50:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?biotech',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '셀트리온', ticker: '068270.KS', trend: 'up' },
          { name: '삼성바이오로직스', ticker: '207940.KS', trend: 'down' }
        ]
      },
      {
        id: '8',
        title: '재택근무 축소 추세...오피스 시장 회복 조짐',
        abstract: '주요 기업들이 재택근무를 축소하고 사무실 복귀를 장려하는 추세가 나타나고 있습니다. 이로 인해 침체되었던 오피스 부동산 시장에 회복 조짐이 보입니다.',
        url: 'https://example.com/office-return',
        byline: '최부동산 기자',
        published_date: '2023-08-08T15:10:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?office',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '미래에셋리츠', ticker: '330590.KS', trend: 'up' },
          { name: '롯데리츠', ticker: '330590.KS', trend: 'down' }
        ]
      },
      {
        id: '9',
        title: '친환경 에너지 정책 강화...신재생 에너지 투자 확대',
        abstract: '주요국들이 친환경 에너지 정책을 강화하고 있는 가운데, 태양광, 풍력 등 신재생 에너지 분야에 대한 투자가 확대되고 있습니다.',
        url: 'https://example.com/renewable-energy',
        byline: '이에너지 기자',
        published_date: '2023-08-07T12:40:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?renewable',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '한화솔루션', ticker: '009830.KS', trend: 'up' },
          { name: '현대에너지솔루션', ticker: '322000.KS', trend: 'up' }
        ]
      },
      {
        id: '10',
        title: '농산물 가격 상승...식품 인플레이션 우려',
        abstract: '기후 변화로 인한 작황 부진과 비료 가격 상승으로 농산물 가격이 급등하고 있습니다. 이로 인한 식품 인플레이션 우려가 커지고 있습니다.',
        url: 'https://example.com/agriculture-prices',
        byline: '정농업 기자',
        published_date: '2023-08-06T11:30:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?farm',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: 'CJ제일제당', ticker: '097950.KS', trend: 'down' },
          { name: '농심', ticker: '004370.KS', trend: 'down' }
        ]
      },
      {
        id: '11',
        title: '전기차 시장 성장세 지속...배터리 수요 급증',
        abstract: '글로벌 전기차 시장이 예상보다 빠른 성장세를 보이고 있습니다. 이에 따라 배터리 제조사들의 생산 능력 확대와 원자재 확보 경쟁이 치열해지고 있습니다.',
        url: 'https://example.com/ev-market-growth',
        byline: '김모빌리티 기자',
        published_date: '2023-08-05T14:15:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?electric-car',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: 'LG화학', ticker: '051910.KS', trend: 'up' },
          { name: '삼성SDI', ticker: '006400.KS', trend: 'up' }
        ]
      },
      {
        id: '12',
        title: '디지털 광고 시장 개편...개인정보 보호 강화 영향',
        abstract: '개인정보 보호 규제 강화로 디지털 광고 시장이 개편되고 있습니다. 대형 플랫폼 기업들은 새로운 타겟팅 방식을 모색하고 있습니다.',
        url: 'https://example.com/digital-advertising',
        byline: '박미디어 기자',
        published_date: '2023-08-04T10:55:00Z',
        multimedia: [
          {
            url: 'https://source.unsplash.com/random/800x600?digital',
            format: 'superJumbo'
          }
        ],
        relatedStocks: [
          { name: '네이버', ticker: '035420.KS', trend: 'down' },
          { name: '카카오', ticker: '035720.KS', trend: 'down' }
        ]
      }
    ] as Article[],
    
    // 카테고리별 기사 분류 기준
    categories: {
      'economic-trends': ['inflation', 'gdp', 'economy', 'growth', 'employment', '인플레이션', '경제', '고용', '성장'],
      'business-industry': ['company', 'corporate', 'industry', 'business', 'earnings', '기업', '산업', '실적'],
      'financial-markets': ['market', 'stock', 'bond', 'investment', 'finance', '시장', '주식', '투자', '금융'],
      'policy-regulation': ['policy', 'regulation', 'government', 'central bank', 'federal reserve', '정책', '규제', '정부', '중앙은행'],
      'global-economy': ['global', 'international', 'trade', 'world', 'tariff', '글로벌', '국제', '무역', '세계']
    }
  }),
  
  getters: {
    // 모든 목업 기사 가져오기
    getAllArticles: (state) => state.mockArticles,
    
    // 카테고리별로 기사 분류
    getCategorizedArticles: (state) => {
      const result = {
        'economic-trends': [] as Article[],
        'business-industry': [] as Article[],
        'financial-markets': [] as Article[],
        'policy-regulation': [] as Article[],
        'global-economy': [] as Article[]
      }
      
      state.mockArticles.forEach(article => {
        const title = article.title.toLowerCase()
        const abstract = article.abstract.toLowerCase()
        const content = title + ' ' + abstract
        
        let assigned = false
        
        // 각 카테고리별 키워드 검사
        for (const [category, keywords] of Object.entries(state.categories)) {
          for (const keyword of keywords) {
            if (content.includes(keyword.toLowerCase())) {
              result[category].push(article)
              assigned = true
              break
            }
          }
          if (assigned) break
        }
        
        // 어떤 카테고리에도 할당되지 않은 경우 기본적으로 business-industry에 추가
        if (!assigned) {
          result['business-industry'].push(article)
        }
      })
      
      return result
    },
    
    // 첫 번째 기사 (메인 하이라이트)
    getFeaturedArticle: (state) => state.mockArticles[0] || null
  }
}) 