<script setup lang="ts">
useServerHead({
  htmlAttrs: { lang: 'kr' },
})
useSeoMeta({
  titleTemplate: '포츈 매트릭스 | %s',
  description: '미국의 주요 뉴스를 포츈 매트릭스가 분석하고 추천합니다.',
  ogImage: 'https://hn.nuxt.dev/cover.jpg',
  ogImageAlt: '포츈 매트릭스',
})

</script>

<template>
  <AppHeader />
  <NuxtPage />
</template>


<style lang="postcss">
body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;
  font-size: 15px;
  background-color: #F4F4F5;
  margin: 0;
  padding: 0;
  color: #020420;
  overflow-y: scroll;
}

a {
  color: #020420;
  text-decoration: none;
}
.header {
  background-color: #020420;
  z-index: 999;
  height: 55px;

  .inner {
    max-width: 800px;
    box-sizing: border-box;
    margin: 0px auto;
    padding: 12px 5px;
    display: flex;
    place-items: center;
  }

  & a {
    color: #fff;
    line-height: 24px;
    transition: color 0.15s ease;
    display: inline-block;
    vertical-align: middle;
    font-weight: 300;
    letter-spacing: 0.075em;
    margin-right: 1.8em;

    &:hover {
      color: #00DC82;
    }

    &.active {
      color: #00DC82;
    }

    &:nth-child(6) {
      margin-right: 0;
    }
  }

  .github {
    color: #fff;
    font-size: 0.9em;
    margin: auto;
    text-align: right;
    flex-grow: 1;
    & a {
      margin-right: 0;
    }
  }
}

.logo {
  width: 30px;
  height: 30px;
  margin-right: 10px;
  display: inline-block;
  vertical-align: middle;
}

.view {
  max-width: 800px;
  margin: 0 auto;
  position: relative;
}

.appear-active {
  transition: opacity 0.4s ease;
}

.appear {
  opacity: 0;
}

@media (max-width: 860px) {
  .header .inner {
    padding: 15px 30px;
  }
}

@media (max-width: 600px) {
  .header {
    .inner {
      padding: 15px;
    }

    & a {
      margin-right: 1em;
    }

    .github {
      display: none;
    }
  }
}
</style>
