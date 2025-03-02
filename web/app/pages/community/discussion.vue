<script setup lang="ts">
useHead({
  title: '토론 게시판 - 포츈 매트릭스',
  meta: [
    { name: 'description', content: '경제 현황, 투자 전략 등에 대한 자유로운 토론 게시판' }
  ]
})

// 토론 주제 데이터
const discussions = ref([
  { 
    id: 1, 
    title: '금리 인상이 부동산 시장에 미치는 영향은?', 
    author: '투자자123', 
    comments: 24, 
    date: new Date('2023-06-15'),
    content: '최근 중앙은행의 금리 인상으로 부동산 시장이 조정을 받고 있습니다. 이러한 상황이 장기적으로 부동산 투자에 어떤 영향을 미칠까요?'
  },
  { 
    id: 2, 
    title: '주식 시장 변동성 대응 전략', 
    author: '주식매니아', 
    comments: 18, 
    date: new Date('2023-06-14'),
    content: '최근 시장 변동성이 확대되고 있는데, 이런 상황에서 어떤 투자 전략이 효과적일까요? 분산 투자와 가치 투자 관점에서 의견을 나누고 싶습니다.'
  },
  // 추가 토론 주제들...
])

const newDiscussion = ref({
  title: '',
  content: ''
})

function addDiscussion() {
  if (newDiscussion.value.title.trim() && newDiscussion.value.content.trim()) {
    discussions.value.unshift({
      id: Date.now(),
      title: newDiscussion.value.title,
      content: newDiscussion.value.content,
      author: '현재사용자',
      comments: 0,
      date: new Date()
    })
    newDiscussion.value.title = ''
    newDiscussion.value.content = ''
  }
}
</script>

<template>
  <div class="page-container">
    <h1 class="page-title">토론 게시판</h1>
    <p class="page-description">경제 현황, 투자 전략 등에 대한 자유로운 토론의 장입니다.</p>
    
    <div class="new-discussion-form">
      <h2>새 토론 주제 작성</h2>
      <div class="input-group">
        <label for="title">제목</label>
        <input id="title" v-model="newDiscussion.title" type="text" placeholder="토론 제목을 입력하세요">
      </div>
      <div class="input-group">
        <label for="content">내용</label>
        <textarea id="content" v-model="newDiscussion.content" rows="5" placeholder="토론 내용을 입력하세요"></textarea>
      </div>
      <button @click="addDiscussion" class="post-button">게시하기</button>
    </div>
    
    <div class="discussions-list">
      <h2>토론 목록</h2>
      <div v-for="discussion in discussions" :key="discussion.id" class="discussion-card">
        <h3 class="discussion-title">{{ discussion.title }}</h3>
        <p class="discussion-content">{{ discussion.content }}</p>
        <div class="discussion-meta">
          <span class="author">{{ discussion.author }}</span>
          <span class="date">{{ discussion.date.toLocaleDateString() }}</span>
          <span class="comments">댓글 {{ discussion.comments }}개</span>
        </div>
      </div>
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
  margin-bottom: v;
}

.new-discussion-form {
  background-color: #f8f8f8;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 30px;
}

.new-discussion-form h2 {
  font-size: 20px;
  margin-bottom: 15px;
}

.input-group {
  margin-bottom: 15px;
}

.input-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: 500;
}

.input-group input, .input-group textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-family: inherit;
}

.post-button {
  background-color: #0066cc;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 500;
}

.discussions-list {
  margin-top: 40px;
}

.discussions-list h2 {
  font-size: 24px;
  margin-bottom: 20px;
}

.discussion-card {
  background-color: white;
  border: 1px solid #eee;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 15px;
  box-shadow: 0 2px 5px rgba(0,0,0,0.05);
}

.discussion-title {
  font-size: 18px;
  margin-bottom: 10px;
  color: #0066cc;
}

.discussion-content {
  color: #333;
  margin-bottom: 15px;
}

.discussion-meta {
  font-size: 12px;
  color: #666;
  display: flex;
  gap: 15px;
}
</style> 