<script setup lang="ts">
const props = defineProps({
  query: {
    type: String,
    default: 'corporate industry earnings strategy'
  },
  limit: {
    type: Number,
    default: 5
  }
})

const searchQuery = ref(props.query)
const page = ref(0)
const sort = ref('newest')

const { data, pending, error, refresh } = useFetch('/api/nyt/articlesearch', {
  params: {
    q: searchQuery,
    fq: 'news_desk:("Business" "Companies" "Dealbook")',
    page,
    sort
  },
  watch: [searchQuery, page, sort]
})

const articles = computed(() => {
  if (!data.value?.articles) return []
  return data.value.articles.slice(0, props.limit)
})

function search() {
  page.value = 0
  refresh()
}
</script>

<template>
  <div class="nyt-business-industry">
    <div class="search-controls">
      <input 
        v-model="searchQuery" 
        type="text" 
        placeholder="기업 또는 산업 키워드 검색" 
        @keyup.enter="search"
      />
      <button @click="search">검색</button>
    </div>
    
    <div v-if="pending" class="loading">
      <LoadSpinner />
    </div>
    <div v-else-if="error" class="error">
      데이터를 불러오는 중 오류가 발생했습니다.
    </div>
    <div v-else-if="articles.length === 0" class="no-results">
      검색 결과가 없습니다.
    </div>
    <div v-else class="articles">
      <h2>기업과 산업</h2>
      <ul class="article-list">
        <li v-for="article in articles" :key="article.id" class="article-item">
          <div v-if="article.multimedia && article.multimedia[0]" class="article-image">
            <img :src="article.multimedia[0].url" :alt="article.title">
          </div>
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
      
      <div class="pagination">
        <button 
          :disabled="page === 0" 
          @click="page--"
        >이전</button>
        <span>{{ page + 1 }}페이지</span>
        <button @click="page++">다음</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.nyt-business-industry {
  margin-bottom: 30px;
}

.search-controls {
  display: flex;
  margin-bottom: 20px;
  gap: 10px;
}

.search-controls input {
  flex-grow: 1;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.search-controls button {
  padding: 8px 16px;
  background-color: #0066cc;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
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

.article-image {
  flex: 0 0 120px;
  margin-right: 20px;
}

.article-image img {
  width: 100%;
  height: auto;
  object-fit: cover;
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

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-top: 20px;
}

.pagination button {
  padding: 8px 16px;
  background-color: #f0f0f0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.pagination button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.loading, .error, .no-results {
  text-align: center;
  padding: 20px;
}
</style> 