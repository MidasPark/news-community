<script setup lang="ts">
useHead({
  title: '커뮤니티 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '경제, 금융, 투자에 관한 토론과 정보 공유 커뮤니티' }
  ]
})
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">커뮤니티</h1>
    <p class="page-description">경제, 금융, 투자에 관한 토론과 정보 공유의 장입니다.</p>
    
    <div class="community-categories">
      <NuxtLink to="/community/discussion" class="category-card">
        <h2>토론 게시판</h2>
        <p>경제 현황, 투자 전략 등에 대한 자유로운 토론</p>
      </NuxtLink>
      <NuxtLink to="/community/investment" class="category-card">
        <h2>투자 정보</h2>
        <p>다양한 투자 관련 정보와 팁 공유</p>
      </NuxtLink>
      <NuxtLink to="/community/qna" class="category-card">
        <h2>Q&A</h2>
        <p>경제, 금융에 관한 질문과 답변</p>
      </NuxtLink>
    </div>
    
    <div class="recent-posts">
      <h2>최근 인기 토론</h2>
      <NewYorkTimesCommunity />
    </div>
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

.community-categories {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 20px;
  margin-bottom: 40px;
}

.category-card {
  background-color: #f8f8f8;
  padding: 20px;
  border-radius: 8px;
  text-decoration: none;
  color: inherit;
  transition: transform 0.2s, box-shadow 0.2s;
}

.category-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.category-card h2 {
  font-size: 20px;
  margin-bottom: 10px;
  color: #0066cc;
}

.category-card p {
  color: #666;
  font-size: 14px;
}

.recent-posts {
  margin-top: 40px;
}

.recent-posts h2 {
  font-size: 24px;
  margin-bottom: 20px;
}
</style> 