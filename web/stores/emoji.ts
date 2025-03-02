import { defineStore } from 'pinia'

interface EmojiCategory {
  title: string
  emojis: Record<string, string>
}

export const useEmojiStore = defineStore('emoji', {
  state: () => ({
    categories: {
      reaction: {
        title: '반응',
        emojis: {
          helpful: '👍',
          like: '❤️',
          celebrate: '🎉',
          interesting: '🤔',
          insightful: '💡',
        }
      },
      communication: {
        title: '소통',
        emojis: {
          comment: '💬',
          message: '✉️',
          announcement: '📢',
          question: '❓',
        }
      },
      indicators: {
        title: '지표',
        emojis: {
          up: '▲',
          down: '▼',
          increase: '📈',
          decrease: '📉',
          stable: '📊',
        }
      },
      finance: {
        title: '금융',
        emojis: {
          money: '💰',
          currency: '💲',
          chart: '📊',
          stock: '📈',
        }
      }
    } as Record<string, EmojiCategory>
  }),
  
  getters: {
    getEmoji: (state) => (category: string, name: string): string => {
      return state.categories[category]?.emojis[name] || '❓'
    },
    
    getAllEmojis: (state) => (): Record<string, Record<string, string>> => {
      const result: Record<string, Record<string, string>> = {}
      
      Object.keys(state.categories).forEach(category => {
        result[category] = state.categories[category]?.emojis || {}
      })
      
      return result
    }
  }
}) 