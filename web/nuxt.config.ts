import { resolve } from 'path'

export default defineNuxtConfig({
  future: { compatibilityVersion: 4 },

  // https://nuxt.com/modules
  modules: [
    // '@nuxthub/core',
    '@nuxt/eslint',
    '@pinia/nuxt',
  ],

  // hub: {
  //   cache: true,
  // },

  postcss: {
    plugins: {
      'postcss-nesting': {},
    },
  },

  // https://devtools.nuxt.com
  devtools: {
    enabled: true,
  },

  // https://eslint.nuxt.com
  eslint: {
    config: {
      stylistic: {
        quotes: 'single',
      },
    },
  },

  compatibilityDate: '2025-02-28',

  nitro: {
    devStorage: {
      cache: {
        driver: 'memory'
      }
    }
  },

  alias: {
    '@stores': resolve(__dirname, './stores'),
    '~stores': resolve(__dirname, './stores')
  },

  imports: {
    dirs: [
      'stores'
    ]
  },

  vite: {
    resolve: {
      alias: {
        '@stores': resolve(__dirname, './stores')
      }
    }
  }
})