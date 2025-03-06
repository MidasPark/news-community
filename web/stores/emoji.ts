import { defineStore } from 'pinia'

interface EmojiCategory {
  title: string
  emojis: Record<string, string>
}

export const useEmojiStore = defineStore('emoji', {
  state: () => ({
    emojis: {
      indicators: {
        up: '📈',
        down: '📉'
      },
      reaction: {
        helpful: '👍'
      },
      communication: {
        comment: '💬'
      }
    }
  }),
  getters: {
    getEmoji: (state) => (category, type) => {
      return state.emojis[category]?.[type] || ''
    },
    
    getAllEmojis: (state) => (): Record<string, Record<string, string>> => {
      const result: Record<string, Record<string, string>> = {}
      
      Object.keys(state.emojis).forEach(category => {
        result[category] = state.emojis[category] || {}
      })
      
      return result
    }
  }
}) 