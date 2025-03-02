<script setup lang="ts">
useHead({
  title: '정책과 규제 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '정부의 경제 정책, 중앙은행의 통화 정책, 규제 변화 등을 다루는 기사' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">정책과 규제</h1>
    <p class="page-description">정부의 경제 정책, 중앙은행의 통화 정책, 규제 변화 등을 다루는 기사</p>
    
    <NewYorkTimesBooks
      query="economic policy regulation central bank federal reserve"
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