<script setup lang="ts">
// 이 컴포넌트는 커뮤니티 기능을 제공합니다
// 실제 구현에서는 사용자 댓글 또는 토론을 포함할 수 있습니다
const discussions = ref([
  { id: 1, title: '금리 인상이 부동산 시장에 미치는 영향은?', author: '투자자123', comments: 24, date: new Date('2023-06-15') },
  { id: 2, title: '주식 시장 변동성 대응 전략', author: '주식매니아', comments: 18, date: new Date('2023-06-14') },
  { id: 3, title: '올해 하반기 경제 전망', author: '이코노미스트', comments: 32, date: new Date('2023-06-13') },
  { id: 4, title: '개인 투자자를 위한 채권 투자 가이드', author: '채권전문가', comments: 11, date: new Date('2023-06-12') },
  { id: 5, title: '글로벌 공급망 문제와 인플레이션', author: '글로벌경제', comments: 27, date: new Date('2023-06-11') },
])

const newDiscussion = ref('')

function addDiscussion() {
  if (newDiscussion.value.trim()) {
    discussions.value.unshift({
      id: Date.now(),
      title: newDiscussion.value,
      author: '현재사용자',
      comments: 0,
      date: new Date()
    })
    newDiscussion.value = ''
  }
}
</script>

<template>
  <div class="nyt-community">
    <h2>커뮤니티</h2>
    
    <div class="new-discussion">
      <input 
        v-model="newDiscussion" 
        type="text" 
        placeholder="새 토론 주제 작성..." 
        @keyup.enter="addDiscussion"
      />
      <button @click="addDiscussion">게시</button>
    </div>
    
    <ul class="discussion-list">
      <li v-for="discussion in discussions" :key="discussion.id" class="discussion-item">
        <div class="discussion-content">
          <h3 class="discussion-title">
            <a href="#" @click.prevent>{{ discussion.title }}</a>
          </h3>
          <p class="discussion-meta">
            {{ discussion.author }} | {{ discussion.date.toLocaleDateString() }} | 댓글 {{ discussion.comments }}개
          </p>
        </div>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.nyt-community {
  margin-bottom: 30px;
}

.new-discussion {
  display: flex;
  margin-bottom: 20px;
  gap: 10px;
}

.new-discussion input {
  flex-grow: 1;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.new-discussion button {
  padding: 8px 16px;
  background-color: #0066cc;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.discussion-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.discussion-item {
  padding: 15px;
  margin-bottom: 15px;
  background-color: #f8f8f8;
  border-radius: 4px;
  transition: background-color 0.2s;
}

.discussion-item:hover {
  background-color: #f0f0f0;
}

.discussion-title {
  font-size: 18px;
  margin: 0 0 10px 0;
}

.discussion-title a {
  color: #0066cc;
  text-decoration: none;
}

.discussion-meta {
  font-size: 12px;
  color: #666;
  margin: 0;
}
</style> 