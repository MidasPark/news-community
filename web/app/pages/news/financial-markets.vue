<script setup lang="ts">
useHead({
  title: '금융 시장 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '주식, 채권, 외환 시장 등 금융 시장의 움직임과 투자 관련 기사' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">금융 시장</h1>
    <p class="page-description">주식, 채권, 외환 시장 등 금융 시장의 움직임과 투자 관련 기사</p>
    
    <NewYorkTimesMostPopular 
      query="stock market bonds forex investment"
      period="7"
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

/* 반응형 미디어 쿼리 추가 */
@media (max-width: 767px) {
  .page-container {
    padding: 15px;
  }
  
  .page-title {
    font-size: 24px;
  }
  
  .page-description {
    font-size: 14px;
    margin-bottom: 20px;
  }
}
</style> 