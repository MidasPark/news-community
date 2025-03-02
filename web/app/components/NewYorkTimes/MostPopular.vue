<script setup lang="ts">
const props = defineProps({
  query: {
    type: String,
    default: 'stock market bonds forex investment'
  },
  period: {
    type: String,
    default: '7',
    validator: (value: string) => ['1', '7', '30'].includes(value)
  },
  limit: {
    type: Number,
    default: 5
  }
})

// 실제로는 검색 API를 사용하되, 금융 시장 관련 뉴스로 필터링
const { data, pending, error, refresh } = useFetch('/api/nyt/articlesearch', {
  params: {
    q: props.query,
    fq: 'news_desk:("Business" "Financial" "Markets" "Your Money")',
    sort: 'newest'
  }
})

const articles = computed(() => {
  if (!data.value?.articles) return []
  return data.value.articles.slice(0, props.limit)
})

const periodLabel = computed(() => {
  const periods = {
    '1': '오늘',
    '7': '이번 주',
    '30': '이번 달'
  }
  return periods[props.period]
})
</script>

<template>
  <div class="nyt-financial-markets">
    <div v-if="pending" class="loading">
      <LoadSpinner />
    </div>
    <div v-else-if="error" class="error">
      데이터를 불러오는 중 오류가 발생했습니다.
    </div>
    <div v-else class="articles">
      <h2>금융 시장</h2>
      <ul class="article-list">
        <li v-for="(article, index) in articles" :key="article.id" class="article-item">
          <div class="article-rank">{{ index + 1 }}</div>
          <div class="article-content">
            <h3 class="article-title">
              <a :href="article.url" target="_blank" rel="noopener">{{ article.title }}</a>
            </h3>
            <p class="article-abstract">{{ article.abstract }}</p>
            <p class="article-meta">
              {{ article.byline }} | {{ new Date(article.published_date).toLocaleDateString() }}
            </p>
          </div>
        </li>
      </ul>
      <button @click="refresh" class="refresh-button">새로고침</button>
    </div>
  </div>
</template>

<style scoped>
.nyt-financial-markets {
  margin-bottom: 30px;
}

.article-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.article-item {
  display: flex;
  margin-bottom: 20px;
  padding-bottom: 20px;
  border-bottom: 1px solid #eee;
}

.article-rank {
  flex: 0 0 40px;
  font-size: 24px;
  font-weight: bold;
  color: #0066cc;
  text-align: center;
}

.article-content {
  flex: 1;
}

.article-title {
  font-size: 18px;
  margin: 0 0 10px 0;
}

.article-abstract {
  font-size: 14px;
  color: #333;
  margin: 0 0 10px 0;
}

.article-meta {
  font-size: 12px;
  color: #666;
}

.refresh-button {
  background-color: #0066cc;
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}

.refresh-button:hover {
  background-color: #004c99;
}

.loading, .error {
  text-align: center;
  padding: 20px;
}
</style> 