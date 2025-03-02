<script setup lang="ts">
const props = defineProps({
  query: {
    type: String,
    default: 'economic policy regulation central bank federal reserve'
  },
  limit: {
    type: Number,
    default: 5
  }
})

const { data, pending, error, refresh } = useFetch('/api/nyt/articlesearch', {
  params: {
    q: props.query,
    fq: 'news_desk:("Business" "Economy" "Washington" "Politics")',
    sort: 'newest'
  }
})

const articles = computed(() => {
  if (!data.value?.articles) return []
  return data.value.articles.slice(0, props.limit)
})
</script>

<template>
  <div class="nyt-policy-regulation">
    <div v-if="pending" class="loading">
      <LoadSpinner />
    </div>
    <div v-else-if="error" class="error">
      데이터를 불러오는 중 오류가 발생했습니다.
    </div>
    <div v-else class="articles">
      <h2>정책과 규제</h2>
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
      <button @click="refresh" class="refresh-button">새로고침</button>
    </div>
  </div>
</template>

<style scoped>
.nyt-policy-regulation {
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