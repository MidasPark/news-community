<script setup lang="ts">
const activeComponent = ref('topstories')
</script>

<template>
  <div class="nyt-demo">
    <h1>뉴욕타임즈 API 데모</h1>
    
    <div class="component-selector">
      <button 
        :class="{ active: activeComponent === 'topstories' }"
        @click="activeComponent = 'topstories'"
      >
        Top Stories
      </button>
      <button 
        :class="{ active: activeComponent === 'search' }"
        @click="activeComponent = 'search'"
      >
        Article Search
      </button>
      <button 
        :class="{ active: activeComponent === 'popular' }"
        @click="activeComponent = 'popular'"
      >
        Most Popular
      </button>
      <button 
        :class="{ active: activeComponent === 'books' }"
        @click="activeComponent = 'books'"
      >
        Books
      </button>
    </div>
    
    <div class="component-container">
      <ClientOnly>
        <NewYorkTimesTopStories v-if="activeComponent === 'topstories'" section="business" :limit="5" />
        <NewYorkTimesArticleSearch v-else-if="activeComponent === 'search'" query="technology" :limit="5" />
        <NewYorkTimesMostPopular v-else-if="activeComponent === 'popular'" period="7" type="viewed" :limit="5" />
        <NewYorkTimesBooks v-else-if="activeComponent === 'books'" list="hardcover-fiction" :limit="5" />
      </ClientOnly>
    </div>
  </div>
</template>

<style scoped>
.nyt-demo {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
}

.component-selector {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-bottom: 30px;
}

.component-selector button {
  padding: 10px 20px;
  background-color: #f0f0f0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.component-selector button.active {
  background-color: #0066cc;
  color: white;
}

.component-container {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}
</style> 