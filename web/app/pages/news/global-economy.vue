<script setup lang="ts">
useHead({
  title: '국제 경제 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '글로벌 경제 이슈, 무역, 국제 관계가 경제에 미치는 영향 등을 다루는 기사' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">국제 경제</h1>
    <p class="page-description">글로벌 경제 이슈, 무역, 국제 관계가 경제에 미치는 영향 등을 다루는 기사</p>
    
    <NewYorkTimesGlobalEconomy
      query="global economy international trade tariffs"
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