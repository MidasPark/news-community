<script setup lang="ts">
// 페이지 제목과 메타데이터 설정
useHead({
  title: '경제 동향 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: 'GDP, 경제 성장, 인플레이션, 고용 등 거시경제 지표와 전반적인 경제 상황을 다루는 기사' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">경제 동향</h1>
    <p class="page-description">GDP, 경제 성장, 인플레이션, 고용 등 거시경제 지표와 전반적인 경제 상황을 다루는 기사</p>
    
    <NewYorkTimesTopStories 
      section="business"
      query="economy inflation gdp employment"
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