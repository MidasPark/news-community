// Shared between app & server
export const feedsInfo = {
  business: { title: '경제', pages: 10 },
  technology: { title: '기술', pages: 10 },
  science: { title: '과학', pages: 10 },
  health: { title: '건강', pages: 10 },
  arts: { title: '예술', pages: 10 },
  // 기존 해커뉴스 피드는 주석 처리하거나 제거
  // news: { title: 'Top', pages: 10 },
  // newest: { title: 'New', pages: 10 },
  // ask: { title: 'Ask', pages: 10 },
  // show: { title: 'Show', pages: 10 },
  // jobs: { title: 'Jobs', pages: 10 },
}

export const validFeeds = Object.keys(feedsInfo)
