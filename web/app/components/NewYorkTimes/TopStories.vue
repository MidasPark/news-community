<script setup lang="ts">
const props = defineProps({
  section: {
    type: String,
    default: 'business'
  },
  query: {
    type: String,
    default: 'economy inflation gdp employment'
  },
  limit: {
    type: Number,
    default: 5
  }
})

const { data, pending, error, refresh } = useFetch('/api/nyt/articlesearch', {
  params: {
    q: props.query,
    fq: `news_desk:("Business" "Economy") AND section_name:"${props.section}"`,
    sort: 'newest'
  }
})

const articles = computed(() => {
  if (!data.value?.articles) return []
  return data.value.articles.slice(0, props.limit)
})
</script>

<template>
  <div class="nyt-economy-trends">
    <div v-if="pending" class="loading">
      <LoadSpinner />
    </div>
    <div v-else-if="error" class="error">
      데이터를 불러오는 중 오류가 발생했습니다.
    </div>
    <div v-else class="articles">
      <h2>경제 동향</h2>
      <ul class="story-list">
        <li v-for="article in articles" :key="article.id" class="story-item">
          <div v-if="article.multimedia && article.multimedia[0]" class="story-image">
            <img :src="article.multimedia[0].url" :alt="article.title">
          </div>
          <div class="story-content">
            <h3 class="story-title">
              <a :href="article.url" target="_blank" rel="noopener">{{ article.title }}</a>
            </h3>
            <p class="story-abstract">{{ article.abstract }}</p>
            <p class="story-meta">
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
.nyt-economy-trends {
  margin-bottom: 30px;
}

.story-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.story-item {
  display: flex;
  margin-bottom: 20px;
  padding-bottom: 20px;
  border-bottom: 1px solid #eee;
}

.story-image {
  flex: 0 0 120px;
  margin-right: 20px;
}

.story-image img {
  width: 100%;
  height: auto;
  object-fit: cover;
}

.story-content {
  flex: 1;
}

.story-title {
  font-size: 18px;
  margin: 0 0 10px 0;
}

.story-abstract {
  font-size: 14px;
  color: #333;
  margin: 0 0 10px 0;
}

.story-meta {
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