<template>
  <header class="app-header">
    <nav class="main-nav">
      <ul class="nav-list">
        <li class="nav-item">
          <NuxtLink to="/" class="nav-link">홈</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/news/economic-trends" class="nav-link">경제 동향</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/news/business-industry" class="nav-link">기업과 산업</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/news/financial-markets" class="nav-link">금융 시장</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/news/policy-regulation" class="nav-link">정책과 규제</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/news/global-economy" class="nav-link">국제 경제</NuxtLink>
        </li>
        <li class="nav-item">
          <NuxtLink to="/community" class="nav-link">커뮤니티</NuxtLink>
        </li>
      </ul>
    </nav>
  </header>
</template>

<style scoped>
.app-header {
  background-color: #f8f8f8;
  padding: 15px 0;
  border-bottom: 1px solid #e2e2e2;
}

.main-nav {
  max-width: 800px;
  margin: 0 auto;
}

.nav-list {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  flex-wrap: wrap;
  justify-content: center;
}

.nav-item {
  margin: 0 10px;
}

.nav-link {
  text-decoration: none;
  color: #333;
  font-weight: 500;
  font-size: 16px;
  padding: 5px 0;
  transition: color 0.2s;
}

.nav-link:hover, .router-link-active {
  color: #0066cc;
  border-bottom: 2px solid #0066cc;
}

@media (max-width: 768px) {
  .nav-list {
    flex-direction: column;
    align-items: center;
  }
  
  .nav-item {
    margin: 5px 0;
  }
}
</style>
