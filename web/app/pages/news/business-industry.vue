<script setup lang="ts">
useHead({
  title: '기업과 산업 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '주요 기업들의 실적, 산업 동향, 기업 전략 등을 다루는 기사' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">기업과 산업</h1>
    <p class="page-description">주요 기업들의 실적, 산업 동향, 기업 전략 등을 다루는 기사</p>
    
    <NewYorkTimesArticleSearch 
      query="corporate industry earnings strategy"
      :limit="10"
    />
  </div>
</template>

<style scoped>
.page-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.page-title {
  font-size: 28px;
  margin-bottom: 10px;
}

.page-description {
  color: #666;
  margin-bottom: 30px;
}
</style> 