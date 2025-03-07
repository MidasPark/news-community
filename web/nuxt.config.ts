import { resolve } from 'path'

export default defineNuxtConfig({
  future: { compatibilityVersion: 4 },

  // https://nuxt.com/modules
  modules: [
    // '@nuxthub/core',
    '@nuxt/eslint',
    '@pinia/nuxt',
  ],

  plugins: [
    '~/plugins/firebase'
  ],

  runtimeConfig: {
    public: {
      firebaseApiKey: process.env.FIREBASE_API_KEY,
      firebaseAuthDomain: process.env.FIREBASE_AUTH_DOMAIN,
      firebaseProjectId: process.env.FIREBASE_PROJECT_ID,
      firebaseStorageBucket: process.env.FIREBASE_STORAGE_BUCKET,
      firebaseMessagingSenderId: process.env.FIREBASE_MESSAGING_SENDER_ID,
      firebaseAppId: process.env.FIREBASE_APP_ID
    }
  },

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
        '@stores': resolve(__dirname, './stores'),
        '@components': resolve(__dirname, './components'),
        '@plugins': resolve(__dirname, './plugins')
      }
    }
  }
})