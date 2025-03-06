<script setup lang="ts">
import { ref, computed, onMounted } from 'vue'
import { useNewsStore } from '@stores/news'
import { useEmojiStore } from '@stores/emoji'
import LoginButton from '@components/LoginButton.vue'


// 뉴스 스토어 사용
const newsStore = useNewsStore()
// 이모티콘 스토어 사용
const emojiStore = useEmojiStore()

// 로딩 상태
const loading = ref(true)
const aiAnalysisLoading = ref(false)

// 스토어에서 최신 뉴스 5개만 가져오기
const featuredNews = computed(() => newsStore.getAllArticles.slice(0, 5))
const mainNews = computed(() => featuredNews.value[0] || null)
const secondaryNews = computed(() => featuredNews.value.slice(1, 5) || [])

// AI 분석 결과
const aiAnalysisResult = ref(new Map())

// AI 시황 분석 함수
function analyzeWithAI(articleId: string) {
  // 이미 분석 결과가 있는지 확인
  if (aiAnalysisResult.value.has(articleId)) {
    // 이미 분석 결과가 있으면 토글
    aiAnalysisResult.value.delete(articleId)
    return
  }
  
  // 로딩 상태 설정
  aiAnalysisLoading.value = true
  
  // 실제로는 API 호출을 통해 AI 분석 결과를 가져옴
  setTimeout(() => {
    // 목업 AI 분석 결과
    const analyses = [
      "이 뉴스는 S&P 500에 단기적으로 긍정적 영향을 줄 것으로 예상됩니다. 기술주 중심으로 상승세가 예상됩니다.",
      "뉴욕증시에 부정적 영향이 예상됩니다. 금리 정책 변화로 인한 시장 불안정성이 증가할 수 있습니다.",
      "NASDAQ 지수에 중립적 영향이 예상됩니다. 단, 대형 기술주는 실적 발표 이후 상승 가능성이 있습니다.",
      "다우지수에 긍정적 영향이 예상됩니다. 소비재와 산업재 섹터가 특히 수혜를 받을 전망입니다.",
      "미국 국채 수익률 상승으로 인한 기술주 중심의 하락 압력이 예상됩니다. 방어주로의 자금 이동에 주목하세요."
    ]
    
    // 랜덤 분석 결과 선택
    const randomAnalysis = analyses[Math.floor(Math.random() * analyses.length)]
    aiAnalysisResult.value.set(articleId, randomAnalysis)
    
    // 로딩 상태 해제
    aiAnalysisLoading.value = false
  }, 1000)
}

// 도움돼요 버튼 클릭 처리 함수
const helpfulCounts = ref(new Map())

function toggleHelpful(articleId: string) {
  const currentCount = helpfulCounts.value.get(articleId) || 0
  helpfulCounts.value.set(articleId, currentCount + 1)
}

// 뉴스 섹션 정보
const newsSections = {
  'economic-trends': { name: '경제 동향', color: '#4CAF50' },
  'business-industry': { name: '기업과 산업', color: '#2196F3' },
  'financial-markets': { name: '금융 시장', color: '#FF9800' },
  'policy-regulation': { name: '정책과 규제', color: '#9C27B0' },
  'global-economy': { name: '국제 경제', color: '#F44336' }
}

// 뉴스 섹션 가져오기 (없으면 랜덤 배정)
function getNewsSection(article) {
  if (article.section && newsSections[article.section]) {
    return article.section
  }
  // 목업 데이터용: 없으면 랜덤 섹션 배정
  const sectionKeys = Object.keys(newsSections)
  return sectionKeys[Math.floor(Math.random() * sectionKeys.length)]
}

// 페이지 로드 시 데이터 로딩 시뮬레이션
onMounted(() => {
  // 잠시 로딩 시간 시뮬레이션
  setTimeout(() => {
    loading.value = false
    
    // 초기 도움돼요 카운트와 댓글 카운트 설정 (목업 데이터)
    featuredNews.value.forEach(article => {
      // 초기값 설정 (실제로는 API에서 가져온 값 사용)
      if (!article.helpfulCount) {
        helpfulCounts.value.set(article.id, Math.floor(Math.random() * 50))
      } else {
        helpfulCounts.value.set(article.id, article.helpfulCount)
      }
    })
  }, 500)
})

// 댓글 수 표시 (목업 데이터)
function getCommentCount(articleId: string) {
  return Math.floor(Math.random() * 30)
}
</script>

<template>
  <div class="ny-times-home">
    <LoginButton />
    <!-- 헤더 섹션 -->
    <div class="header-section">
      <h1 class="main-title">포츈 매트릭스 추천 뉴스</h1>
      <div class="sub-header">최신 경제 뉴스와 이야기</div>
    </div>

    <LoadSpinner v-if="loading" />
    
    <template v-else>
      <!-- 주요 경제 뉴스 하이라이트 섹션 -->
      <div class="featured-news-section">
        <h2 class="section-title">주요 경제 뉴스 하이라이트</h2>
        
        <div class="news-grid">
          <!-- 메인 뉴스 (가장 큰 카드) -->
          <div class="main-news-card" v-if="mainNews">
            <div class="news-image" v-if="mainNews.multimedia && mainNews.multimedia.length > 0">
              <img :src="mainNews.multimedia[0].url" :alt="mainNews.title">
            </div>
            <div class="news-content">
              <a :href="mainNews.url" target="_blank" rel="noopener" class="news-link">
                <h3 class="news-title">{{ mainNews.title }}</h3>
              </a>
              <div class="news-section-tag" :style="{ backgroundColor: newsSections[getNewsSection(mainNews)].color }">
                {{ newsSections[getNewsSection(mainNews)].name }}
              </div>
              <p class="news-abstract">{{ mainNews.abstract }}</p>
              
              <!-- 관련 주식 정보 -->
              <div class="stock-analysis">
                <h4 class="stock-analysis-title">AI 분석</h4>
                <div class="stock-list">
                  <div v-for="stock in mainNews.relatedStocks" :key="stock.ticker" 
                       :class="['stock-item', stock.trend === 'up' ? 'trend-up' : 'trend-down']">
                    <span class="stock-name">{{ stock.name }}</span>
                    <span class="trend-icon">
                      <i v-if="stock.trend === 'up'" class="trend-icon">{{ emojiStore.getEmoji('indicators', 'up') }}</i>
                      <i v-else class="trend-icon">{{ emojiStore.getEmoji('indicators', 'down') }}</i>
                    </span>
                  </div>
                </div>
              </div>
              
              <div class="article-interaction">
                <button @click="toggleHelpful(mainNews.id)" class="helpful-button">
                  <span class="helpful-icon">{{ emojiStore.getEmoji('reaction', 'helpful') }}</span>
                  <span>도움돼요</span>
                  <span class="helpful-count">{{ helpfulCounts.get(mainNews.id) || 0 }}</span>
                </button>
                
                <div class="comment-counter">
                  <span class="comment-icon">{{ emojiStore.getEmoji('communication', 'comment') }}</span>
                  <span class="comment-count">{{ getCommentCount(mainNews.id) }}</span>
                </div>
              </div>
            </div>
          </div>
          
          <!-- 보조 뉴스 (작은 카드 4개) -->
          <div class="secondary-news-container">
            <div v-for="(article, index) in secondaryNews" 
                 :key="index" 
                 class="secondary-news-card">
              <div class="news-content">
                <a :href="article.url" target="_blank" rel="noopener" class="news-link">
                  <h3 class="news-title">{{ article.title }}</h3>
                </a>
                <div class="news-section-tag small" :style="{ backgroundColor: newsSections[getNewsSection(article)].color }">
                  {{ newsSections[getNewsSection(article)].name }}
                </div>
                <p class="news-abstract">{{ article.abstract }}</p>
                
                <!-- 관련 주식 정보 (간소화된 버전) -->
                <div class="stock-analysis">
                  <h4 class="stock-analysis-title">AI 분석</h4>
                  <div class="stock-list">
                    <div v-for="stock in article.relatedStocks" :key="stock.ticker" 
                         :class="['stock-item', stock.trend === 'up' ? 'trend-up' : 'trend-down']">
                      <span class="stock-name">{{ stock.name }}</span>
                      <span class="trend-icon">
                        <i v-if="stock.trend === 'up'" class="trend-icon">{{ emojiStore.getEmoji('indicators', 'up') }}</i>
                        <i v-else class="trend-icon">{{ emojiStore.getEmoji('indicators', 'down') }}</i>
                      </span>
                    </div>
                  </div>
                </div>
                
                <div class="article-interaction">
                  <button @click="toggleHelpful(article.id)" class="helpful-button compact">
                    <span class="helpful-icon">{{ emojiStore.getEmoji('reaction', 'helpful') }}</span>
                    <span class="helpful-count">{{ helpfulCounts.get(article.id) || 0 }}</span>
                  </button>
                  
                  <div class="comment-counter compact">
                    <span class="comment-icon">{{ emojiStore.getEmoji('communication', 'comment') }}</span>
                    <span class="comment-count">{{ getCommentCount(article.id) }}</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <!-- 커뮤니티 유도 섹션 -->
      <div class="community-section">
        <h2 class="section-title">커뮤니티</h2>
        <p class="section-description">경제 및 금융 관련 토론에 참여하고 정보를 공유하세요.</p>
        
        <div class="community-preview">
          <NuxtLink to="/community" class="community-card">
            <h3>경제 토론 커뮤니티</h3>
            <p>현재 활발한 토론: 금리 정책, 기술주 전망, 인플레이션 트렌드, 글로벌 공급망 이슈</p>
            <span class="join-button">참여하기</span>
          </NuxtLink>
        </div>
      </div>
    </template>
  </div>
</template>

<style scoped>
.ny-times-home {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.header-section {
  text-align: center;
  margin-bottom: 40px;
}

.main-title {
  font-size: 32px;
  margin-bottom: 10px;
  color: #333;
}

.sub-header {
  font-size: 18px;
  color: #666;
}

.section-title {
  font-size: 24px;
  margin-bottom: 20px;
  color: #333;
  padding-bottom: 8px;
  border-bottom: 1px solid #eee;
}

.section-description {
  color: #666;
  margin-bottom: 20px;
}

/* 뉴스 그리드 레이아웃 */
.news-grid {
  display: flex;
  flex-direction: column;
  margin-bottom: 40px;
}

.main-news-card {
  width: 100%;
  margin-bottom: 20px;
}

.secondary-news-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
}

.main-news-card {
  grid-column: 1 / -1;
  display: flex;
  background-color: white;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  gap: 0;
}

.secondary-news-card {
  display: flex;
  flex-direction: column;
  background-color: white;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 10px rgba(0,0,0,0.05);
  height: 100%;
  padding: 20px;
  margin-bottom: 32px;
}

.secondary-news-card:nth-last-child(-n+2) {
  margin-bottom: 0;
}

.news-image {
  position: relative;
  overflow: hidden;
  margin: 0;
  padding: 0;
}

.main-news-card .news-image {
  flex: 0 0 40%;
  max-height: 350px;
  border-radius: 8px 0 0 8px;
}

.news-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s;
  display: block;
}

.news-card:hover .news-image img {
  transform: scale(1.05);
}

.news-content {
  padding: 24px;
  flex: 1;
}

.main-news-card .news-content {
  padding: 24px;
  flex: 1;
}

.news-title {
  font-size: 22px;
  margin-bottom: 10px;
  line-height: 1.3;
}

.secondary-news-card .news-title {
  font-size: 18px;
}

.news-link {
  color: #333;
  text-decoration: none;
}

.news-link:hover .news-title {
  color: #0066cc;
}

.news-abstract {
  color: #666;
  margin-bottom: 15px;
  flex-grow: 1;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.secondary-news-card .news-abstract {
  -webkit-line-clamp: 2;
  font-size: 14px;
}

/* 도움돼요 버튼과 댓글 카운터 스타일 */
.article-interaction {
  display: flex;
  align-items: center;
  margin: 10px 0;
  gap: 15px;
}

.helpful-button {
  display: flex;
  align-items: center;
  gap: 8px;
  background-color: #f5f5f5;
  border: 1px solid #e0e0e0;
  border-radius: 20px;
  padding: 8px 16px;
  font-size: 14px;
  color: #555;
  cursor: pointer;
  transition: all 0.2s ease;
}

.helpful-button:hover {
  background-color: #e8f4ff;
  border-color: #b3d7ff;
}

.helpful-button.compact {
  padding: 5px 10px;
  font-size: 12px;
}

.helpful-icon {
  font-size: 16px;
}

.helpful-count {
  font-weight: bold;
  color: #0066cc;
}

.comment-counter {
  display: flex;
  align-items: center;
  gap: 6px;
  font-size: 14px;
  color: #666;
}

.comment-counter.compact {
  font-size: 12px;
}

.comment-icon {
  font-size: 16px;
}

.comment-count {
  font-weight: bold;
}

/* 주식 정보 스타일 */
.stock-badges {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-bottom: 10px;
}

.stock-badges.compact {
  gap: 5px;
}

.stock-badge {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  padding: 6px 10px;
  border-radius: 4px;
  font-size: 13px;
}

.secondary-news-card .stock-badge {
  font-size: 11px;
  padding: 4px 8px;
}

.trend-up {
  background-color: rgba(0, 200, 83, 0.1);
  border: 1px solid rgba(0, 200, 83, 0.3);
}

.trend-down {
  background-color: rgba(255, 51, 51, 0.1);
  border: 1px solid rgba(255, 51, 51, 0.3);
}

.stock-name {
  font-weight: 500;
}

.stock-ticker {
  color: #666;
  font-size: 12px;
}

.secondary-news-card .stock-ticker {
  display: none;
}

.trend-icon {
  font-style: normal;
  font-weight: bold;
}

.trend-up .trend-icon {
  color: #00c853;
}

.trend-down .trend-icon {
  color: #ff3333;
}

/* 커뮤니티 섹션 스타일 */
.community-section {
  background-color: #f0f7ff;
  padding: 25px;
  border-radius: 8px;
  margin-bottom: 30px;
}

.community-preview {
  margin-top: 20px;
}

.community-card {
  display: block;
  background-color: white;
  padding: 20px;
  border-radius: 8px;
  text-decoration: none;
  color: inherit;
  box-shadow: 0 2px 5px rgba(0,0,0,0.05);
  transition: transform 0.2s;
}

.community-card:hover {
  transform: translateY(-5px);
}

.community-card h3 {
  color: #0066cc;
  font-size: 20px;
  margin-bottom: 10px;
}

.join-button {
  display: inline-block;
  background-color: #0066cc;
  color: white;
  padding: 8px 16px;
  border-radius: 4px;
  margin-top: 15px;
  font-weight: 500;
}

/* 반응형 디자인 */
@media (max-width: 900px) {
  .main-news-card {
    flex-direction: column;
  }
  
  .main-news-card .news-image {
    flex: none;
    height: 250px;
    border-radius: 8px 8px 0 0;
  }
  
  .news-title {
    font-size: 20px;
  }
}

@media (max-width: 768px) {
  .secondary-news-container {
    grid-template-columns: 1fr;
  }
  
  .section-title {
    font-size: 22px;
  }
  
  .main-title {
    font-size: 28px;
  }
  
  .sub-header {
    font-size: 16px;
  }
  
  .main-news-card {
    margin-bottom: 24px;
  }

  .secondary-news-card {
    margin-bottom: 24px;
  }

  .secondary-news-card:last-child {
    margin-bottom: 0;
  }
}

@media (max-width: 480px) {
  .ny-times-home {
    padding: 15px;
  }
  
  .header-section {
    margin-bottom: 25px;
  }
  
  .main-title {
    font-size: 24px;
  }
  
  .news-title {
    font-size: 18px;
  }
  
  .secondary-news-card .news-title {
    font-size: 16px;
  }
  
  .news-content {
    padding: 15px;
  }
  
  .community-section {
    padding: 15px;
  }
}

/* 뉴스 섹션 태그 스타일 수정 */
.news-section-tag {
  display: inline-block;
  padding: 4px 8px;
  border-radius: 4px;
  color: white;
  font-size: 12px;
  font-weight: 500;
  margin-bottom: 10px;
  width: fit-content;
  max-width: 100px;
  text-align: center;
}

.news-section-tag.small {
  font-size: 10px;
  padding: 3px 6px;
  max-width: 80px;
}

/* 주식 분석 스타일 수정 */
.stock-analysis {
  margin: 15px 0;
  padding: 0;
}

.stock-analysis-title {
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 8px;
  color: #333;
}

.stock-list {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.stock-item {
  display: flex;
  align-items: center;
  gap: 6px;
  padding: 4px 8px;
  border-radius: 4px;
  font-size: 13px;
}

.secondary-news-card .stock-analysis {
  margin: 10px 0;
}

.secondary-news-card .stock-analysis-title {
  font-size: 12px;
  margin-bottom: 6px;
}

.secondary-news-card .stock-item {
  font-size: 11px;
  padding: 3px 6px;
}

/* 섹션 태그 색상 */
.news-section-tag[data-section="economic-trends"] {
  background-color: #4CAF50;
}

.news-section-tag[data-section="business-industry"] {
  background-color: #2196F3;
}

.news-section-tag[data-section="financial-markets"] {
  background-color: #FF9800;
}

.news-section-tag[data-section="policy-regulation"] {
  background-color: #9C27B0;
}

.news-section-tag[data-section="global-economy"] {
  background-color: #F44336;
}
</style>
